package interview.datastructures.core;

import interview.datastructures.interf.AbstractList;
import interview.datastructures.interf.List;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


// stuff like pop, peek, poll etc. are trivial to implement once you have these in place
public class LinkedList<T> extends AbstractList<T> {

    private Node<T> head;
    private Node<T> tail;

    public LinkedList(T... args) {
        for (T v : args) {
            add(v);
        }

    }

    public Optional<T> getLast() {
        return Optional.ofNullable(tail.val());
    }

    public Optional<T> getFirst() {
        return Optional.ofNullable(head.val());
    }


    public SPair<List<T>> split(int index) {
        checkIndex(index);
        LinkedList<T> left = new LinkedList<>();
        LinkedList<T> right = new LinkedList<>();

        int size = this.size();
        for(int i = 0; i < size; i++) {
            if(i <= index) {
                left.add(this.get(i));
            } else {
                right.add(this.get(i));
            }
        }

        return new SPair<>(left, right);
    }

    public void print() {
        String val = "[" + this.stream()
                .map(Object::toString)
                .reduce((a, b) -> a + ", " + b)
                        .orElse("") + "]";
        System.out.println(val);
    }

    public void add(T val) {
        Node<T> node = new Node<>(val);
        if (this.isEmpty()) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail.next.previous = tail;
            tail = tail.next;
        }
    }

    public void addFirst(T val) {
        Node<T> node = new Node<>(val);
        if (this.isEmpty()) {
            head = node;
            tail = head;
        } else {
            head.previous = node;
            head.previous.next = head;
            head = head.previous;
        }
    }

    public void addAll(List<T> other) {
        other.stream().forEach(this::add);
    }

    // works like the java.util.LinkedList.remove
    public Optional<T> remove(T val) {

        if (val == null) {
            throw new NullPointerException("Cannot remove null from a list.");
        }

        return indexOf(val).map(this::removeAt);
    }

    public Optional<Integer> indexOf(T val) {
        int i = 0;
        for (Iterator<Node<T>> itc = iterator(); itc.hasNext(); i++) {
            if (Objects.equals(val, itc.next().val())) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public T removeAt(int index) {
        checkIndex(index);
        boolean alreadyUpdated = false;

        Node<T> out = null;
        if (index == 0) {
            Node<T> next = head.next;
            out = head;
            if (next != null) {
                next.previous = null;
            }
            head = next;
            alreadyUpdated = true;
        }

        if (index == size() - 1 && !alreadyUpdated) {
            Node<T> previous = tail.previous;
            out = tail;
            if (previous != null) {
                previous.next = null;
            }
            tail = previous;
            alreadyUpdated = true;
        }

        if (alreadyUpdated) {
            return out.val();
        }

        int i = 0;
        for (Iterator<Node<T>> itc = iterator(); itc.hasNext(); i++) {
            Node<T> c = itc.next();
            if (i == index) {
                c.previous.next = c.next;
                c.next.previous = c.previous;
                out = c;
            }
        }

        return out.val();
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        if (head == tail) {
            return 1;
        }

        int c = 0;
        Node<T> next = head;
        do {
            next = next.next;
            c++;
        } while (next.hasNext());

        return c + 1;
    }

    public void set(T nval, int index) {
        checkIndex(index);

        int i = 0;
        for (Iterator<Node<T>> itc = iterator(); itc.hasNext(); i++) {
            Node<T> c = itc.next();
            if (i == index) {
                Node<T> newNode = new Node<>(nval);

                if (c.previous != null) {
                    c.previous.next = newNode;
                } else {
                    head = newNode;
                }

                newNode.previous = c.previous;
                newNode.next = c.next;

                if (c.next != null) {
                    c.next.previous = newNode;
                } else {
                    tail = newNode;
                }

                break;
            }
        }
    }

    public T get(int index) {
        checkIndex(index);
        int i = 0;
        for (Iterator<Node<T>> iterator = iterator(); iterator.hasNext(); i++) {
            Node<T> node = iterator.next();
            if (i == index) {
                return node.val();
            }
        }

        throw new NoSuchElementException("Should never happen but who knows.");
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof LinkedList)) {
            return false;
        }
        LinkedList<T> oth = (LinkedList<T>) other;

        int size = this.size();
        int othSize = oth.size();

        if (othSize != size) {
            return false;
        }

        if (othSize == 0) {
            return true;
        }

        Iterator<Node<T>> otherIterator = oth.iterator();
        Iterator<Node<T>> thisIterator = this.iterator();
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(otherIterator.next().val(), thisIterator.next().val())) {
                return false;
            }
        }

        return true;
    }

    public Iterator<Node<T>> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Node<T> next() {
                Node<T> val = current;
                current = current.next;
                return val;
            }
        };
    }

    public Iterator<Node<T>> reIterator() {
        return new Iterator<>() {
            private Node<T> current = tail;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Node<T> next() {
                Node<T> val = current;
                current = current.previous;
                return val;
            }
        };
    }

    public Stream<T> stream() {
        Iterable<Node<T>> it = this::iterator;
        Stream<Node<T>> stream = StreamSupport.stream(it.spliterator(), false);
        return stream.map(Node::val);
    }

    public static class Node<T> {
        private T val;

        private Node<T> next;

        private Node<T> previous;

        private Node(T val) {
            this.val = val;
        }

        private boolean hasNext() {
            return next != null;
        }

        public T val() {
            return val;
        }
    }

}


