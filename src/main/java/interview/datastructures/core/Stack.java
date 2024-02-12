package interview.datastructures.core;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.function.Consumer;

public class Stack<T> {

    StackNode<T> top;

    public T pop() throws EmptyStackException {
        if(top == null) {
            throw new EmptyStackException();
        }

        StackNode<T> out = top;
        top = top.next;

        return out.data;
    }
    
    public void push(T data) {
        top = new StackNode<>(data, top);
    }

    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void forEach(Consumer<T> con) {
        StackNode<T> next = top;
        while(next != null) {
            con.accept(next.data);
            next = next.next;
        }
    }

    public List<T> asList() {
        List<T> out = new ArrayList();
        this.forEach(out::add);
        return out;
    }

    private static class StackNode<T> {
        T data;
        StackNode<T> next;

        private StackNode(T data, StackNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
