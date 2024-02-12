package interview.datastructures.core;

import interview.datastructures.interf.AbstractList;
import interview.datastructures.interf.List;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ArrayList<T> extends AbstractList<T> {

    Integer size;
    private int elementCounter;
    private Object[] array;

    public ArrayList(T... args) {
        int size = (int) Arrays.stream(args).filter(Objects::nonNull).count();
        this.elementCounter = size;
        if (size < 10) {
            this.size = 10;
        } else {
            this.size = (int) (size * 1.5);
        }
        array = new Object[this.size];
        for (int i = 0; i < size; i++) {
            this.array[i] = args[i];
        }
    }

    @Override
    public Optional<T> getLast() {
        return isEmpty() ? Optional.empty() : Optional.of((T) array[elementCounter]);
    }

    @Override
    public Optional<T> getFirst() {
        return isEmpty() ? Optional.empty() : Optional.of((T) array[0]);
    }

    @Override
    public SPair<List<T>> split(final int index) {
        Object[] left = new Object[this.elementCounter];
        Object[] right = new Object[this.elementCounter];

        for (int i = 0; i < this.elementCounter; i++) {
            if (i <= index) {
                left[i] = this.array[i];
            } else {
                right[i - index - 1] = this.array[i];
            }
        }

        return new SPair<>(new ArrayList<>((T[]) left), new ArrayList<>((T[]) right));
    }

    @Override
    public void add(final T val) {
        resizeIfNecessary();
        array[elementCounter] = val;
        elementCounter++;
    }

    @Override
    public void addFirst(final T val) {
        resizeIfNecessary();
        for (int i = elementCounter - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = val;
        elementCounter++;
    }

    @Override
    public void addAll(final List<T> other) {
        // not optimal but I dont care
        other.stream().filter(Objects::nonNull).forEach(this::add);
    }

    @Override
    public Optional<T> remove(final T val) {
        return indexOf(val).map(this::removeAt);
    }

    public void removeAll() {
        this.array = new Object[size];
        this.elementCounter = 0;
    }

    @Override
    public Optional<Integer> indexOf(final T val) {
        for (int i = 0; i < elementCounter; i++) {
            if (Objects.equals(val, (T) array[i])) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }

    @Override
    public T removeAt(final int index) {
        T element = get(index);

        for (int i = index + 1; i < elementCounter; i++) {
            array[i - 1] = array[i];
        }
        elementCounter--;
        array[elementCounter] = null;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    public int count() {
        return elementCounter;
    }

    @Override
    public void set(final T nval, final int index) {
        checkIndex(index);
        array[index] = nval;
    }

    @Override
    public T get(final int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public boolean isEmpty() {
        return elementCounter == 0;
    }

    @Override
    public Stream<T> stream() {
        return (Stream<T>) Arrays.stream(array);
    }

    private void resizeIfNecessary() {
        if (elementCounter + 1 > size) {
            resize();
        }
    }

    void resize() {
        int newSize = this.size * 2;
        resize(newSize);
    }

    void resize(int newSize) {
        Object[] newArray = new Object[newSize];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
        this.size = newSize;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ArrayList)) {
            return false;
        }
        ArrayList<T> oth = (ArrayList<T>) other;

        int ec = this.elementCounter;
        int othEc = oth.elementCounter;

        if (othEc != ec) {
            return false;
        }

        if (othEc == 0) {
            return true;
        }

        for (int i = 0; i < size; i++) {
            if (!Objects.equals(this.get(i), oth.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static class ArrayList2D<T> extends ArrayList<ArrayList<T>> {}

}
