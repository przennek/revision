package interview.datastructures.core;

import interview.datastructures.core.ArrayList.ArrayList2D;

import java.util.Objects;
import java.util.Optional;

public class HashTable<K, V> {

    private ArrayList2D<Pair<K,V>> elements;
    private Integer size;
    private int elementsCounter;

    public HashTable() {
        elements = new ArrayList2D<>();
        size = elements.size;
        elementsCounter = 0;
    }

    private HashTable(ArrayList2D<Pair<K, V>> elements) {
        this.elementsCounter = elements.count();
        this.size = elements.size;
        this.elements = elements;
    }

    public void put(K key, V element) {
        if(elementsCounter + 1 >= size) {
            resize();
        }

        int hash = hash(key.hashCode());
        ArrayList<Pair<K, V>> colliding = this.elements.get(hash);

        if(colliding == null) {
            this.elements.set(new ArrayList<>(), hash);
            colliding = this.elements.get(hash);
        }
        
        if(colliding.isEmpty()) {
            colliding.add(new Pair<>(key, element));
            elementsCounter++;
        } else {
            boolean found = false;
            for(int i = 0; i < colliding.count(); i++) {
                if(colliding.get(i).equals(element)) {
                    found = true;
                }
            }
            if(!found) {
                colliding.add(new Pair<>(key, element));
                elementsCounter++;
            }
        }
    }

    public Optional<V> get(K key) {
        int hash = hash(key.hashCode());
        ArrayList<Pair<K, V>> colliding = this.elements.get(hash);
        if(colliding.isEmpty()) {
            return Optional.empty();
        }
        if(colliding.count() == 1) {
            return Optional.of(colliding.get(0).getRight());
        }

        for(int i = 0; i < colliding.count(); i++) {
            Pair<K, V> kv = colliding.get(i);
            if(kv.getLeft().equals(key)) {
                return Optional.of(kv.getRight());
            }
        }

        return Optional.empty();
    }

    public Optional<V> remove(K key) {
        int hash = hash(key.hashCode());
        ArrayList<Pair<K, V>> colliding = this.elements.get(hash);
        if(colliding.isEmpty()) {
            return Optional.empty();
        }
        if(colliding.count() == 1) {
            Pair<K, V> kvPair = colliding.get(0);
            colliding.remove(kvPair);
            elementsCounter--;
            return Optional.of(kvPair.getRight());
        }

        for(int i = 0; i < colliding.count(); i++) {
            Pair<K, V> kv = colliding.get(i);
            if(kv.getLeft().equals(key)) {
                colliding.remove(kv);
                elementsCounter--;
                return Optional.of(kv.getRight());
            }
        }

        return Optional.empty();
    }

    public int count() {
        return elementsCounter;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.elementsCounter == 0;
    }

    public Set<K> keySet() {
        return (Set<K>) new Set<>(entrySet().keyStream().map(Pair::getLeft).toArray());
    }

    public Set<V> values() {
        return (Set<V>) new Set<>(entrySet().keyStream().map(Pair::getRight).toArray());
    }

    public Set<Pair<K, V>> entrySet() {
        ArrayList<Pair<K, V>> out = new ArrayList<>();
        elements.stream()
                .filter(Objects::nonNull)
                .flatMap(ArrayList::stream)
                .filter(Objects::nonNull)
                .forEach(out::add);

        return new Set<>(out);
    }

    private void resize() {
        ArrayList2D<Pair<K, V>> newEl = new ArrayList2D<>();
        newEl.resize(this.size * 2);
        HashTable<K, V> newHt = new HashTable<>(newEl);

        this.entrySet().keyStream()
                .forEach(pair -> newHt.put(pair.getLeft(), pair.getRight()));

        this.elements = newHt.elements;
        this.elementsCounter = newHt.elementsCounter;
        this.size = newHt.size;
    }

    private int hash(final int code) {
        return Math.abs(code % size);
    }

}
