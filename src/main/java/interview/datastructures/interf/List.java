package interview.datastructures.interf;

import interview.datastructures.core.Pair;
import interview.datastructures.core.SPair;

import java.util.Optional;
import java.util.stream.Stream;

public interface List<T> {
    Optional<T> getLast();

    Optional<T> getFirst();

    SPair<List<T>> split(int index);

    void swap(int index1, int index2);

    void add(T val);

    void addFirst(T val);

    public void addAll(List<T> other);

    Optional<T> remove(T val);

    Optional<Integer> indexOf(T val);

    T removeAt(int index);

    int size();

    void set(T nval, int index);

    T get(int index);

    boolean isEmpty();

    Stream<T> stream();

    default void print() {
        String val = "[" + this.stream()
                .map(Object::toString)
                .reduce((a, b) -> a + ", " + b)
                .orElse("") + "]";
        System.out.println(val);
    }

}
