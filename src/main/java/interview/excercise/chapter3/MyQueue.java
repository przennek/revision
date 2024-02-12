package interview.excercise.chapter3;

import interview.datastructures.core.Stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    Stack<T> a = new Stack<>();
    Stack<T> b = new Stack<>();

    public void push(T data) {
        a.push(data);
    }

    T remove() {
        if(b.isEmpty()) {
            while(!a.isEmpty()) {
                b.push(a.pop());
            }
        }

        try {
            T out = b.pop();
            return out;
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    boolean isEmpty() {
        return  a.isEmpty();
    }
}
