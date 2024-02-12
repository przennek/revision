package interview.datastructures.core;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Set<T> {

    private ArrayList<ArrayList<T>> elements;
    private Integer size;
    private Integer elementCounter = 0; // counting elements including collisions

    public Set(T... elements) {
        this.elements = new ArrayList<>();
        this.size = this.elements.size; // hack but I'm too lazy
        Arrays.stream(elements).filter(Objects::nonNull).forEach(this::add);
    }

    public Set(ArrayList<T> elements) {
        this.elements = new ArrayList<>();
        this.size = this.elements.size; // hack but I'm too lazy
        elements.stream().filter(Objects::nonNull).forEach(this::add);
    }

    public void add(T el) {
        if (size < elementCounter + 1) {
            resize();
        }

        int code = el.hashCode();
        int index = hash(code);
        ArrayList<T> colliding = elements.get(index);

        if (colliding == null) {
            ArrayList<T> nval = new ArrayList<>();
            elements.set(nval, index);
            colliding = nval;
        }

        for (int i = 0; i < colliding.size(); i++) {
            if (Objects.equals(colliding.get(i), el)) {
                return;
            }
        }
        colliding.add(el);
        elementCounter++;
    }

    public boolean contains(T el) {
        return Optional.ofNullable(elements.get(hash(el.hashCode())))
                .orElse(new ArrayList<>())
                .stream()
                .filter(Objects::nonNull)
                .anyMatch(it -> it.equals(el));
    }

    private int hash(final int code) {
        return code % size;
    }

    public Optional<T> remove(T el) {
        int code = el.hashCode();
        ArrayList<T> colliding = elements.get(hash(code));
        for (int i = 0; i < colliding.size(); i++) {
            T element = colliding.get(i);
            if (element.equals(el)) {
                colliding.remove(el);
                elementCounter--;
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    public boolean isEmpty() {
        return elementCounter == 0;
    }

    public Stream<T> keyStream() {
        return elements.stream().filter(Objects::nonNull).flatMap(ArrayList::stream).filter(Objects::nonNull);
    }

    public void resize() {
        ArrayList<ArrayList<T>> newEl = new ArrayList<>();
        newEl.resize(this.size * 2);

        Set<T> d = new Set<>();
        d.elements = newEl;
        d.size = newEl.size;
        d.elementCounter = 0;

        keyStream().forEach(d::add);

        this.elements = d.elements;
        this.size = d.size;
        this.elementCounter = d.elementCounter;
    }

    public boolean equals(Object other) {
        if (!(other == null || other instanceof Set)) {
            return false;
        }

        Set<T> otherSet = (Set) other;
        if (!Objects.equals(otherSet.elementCounter, this.elementCounter)) {
            return false;
        }

        ArrayList<T> otherValues = new ArrayList<>();
        otherSet.keyStream().forEach(otherValues::add);

        ArrayList<T> thisValues = new ArrayList<>();
        otherSet.keyStream().forEach(thisValues::add);

        return thisValues.equals(otherValues);
    }
}
