package interview.datastructures.core;

import java.util.NoSuchElementException;

public class Queue<T> {

    private QueueNode<T> last;
    private QueueNode<T> first;

    public void add(T data) {
        if(first == null) {
            first = new QueueNode<>(data);
            last = first;
        } else {
            QueueNode<T> next = new QueueNode<>(data);
            last.next = next;
            last = next;
        }
    }

    public T remove() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        if(isOneElementOnly()) {
            last = null;
            first = null;
        } else {
            first = first.next;
        }
        return data;
    }

    public T peek() {
        if(last == null) {
            throw new NoSuchElementException();
        }
        return last.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private boolean isOneElementOnly() {
        return first == last;
    }

    private static class QueueNode<T> {
        T data;
        QueueNode<T> next;

        private QueueNode(T data) {
            this.data = data;
        }
    }
}
