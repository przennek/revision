package interview.datastructures.interf;

public abstract class AbstractList<T> implements List<T> {

    public void swap(int index1, int index2) {
        checkIndex(index1);
        checkIndex(index2);
        T v1 = this.get(index1);
        T v2 = this.get(index2);
        this.set(v2, index1);
        this.set(v1, index2);
    }

    protected void checkIndex(final int index) {
        if (index != 0 && (index < 0 || index >= size())) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

}
