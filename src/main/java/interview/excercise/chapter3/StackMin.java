package interview.excercise.chapter3;

import java.util.EmptyStackException;

public class StackMin<T extends Comparable<T>> {

    private StackNode<T> top;
    private StackNode<T> min;

    public void push(T data) {
        StackNode<T> nn = new StackNode<>(data, top, min);
        if (isEmpty() || min.data.compareTo(data) < 0) {
            min = nn;
        }
        top = nn;
    }

    public T pop() {
        if(isEmpty()) throw new EmptyStackException();

        T data = top.data;
        if(top == min) {
            min = min.nextMin;
        }
        top = top.next;
        return data;
    }

    public T min() {
        if(isEmpty()) throw new EmptyStackException();

        return min.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    static class StackNode<T> {
        T data;
        StackNode<T> next;
        StackNode<T> nextMin;

        StackNode(T d, StackNode<T> n, StackNode<T> nm) {
            this.data = d;
            this.next = n;
            this.nextMin = nm;
        }
    }
}
