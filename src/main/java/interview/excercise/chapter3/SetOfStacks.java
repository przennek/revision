package interview.excercise.chapter3;

import java.util.EmptyStackException;

// not really, stack of stacks :)
public class SetOfStacks<T> {
    int capacity;
    Stack<T> topStack;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(T data) {
        if(topStack == null || topStack.isEmpty() || topStack.currentCapacity >= capacity) {
            topStack = new Stack<>(null, topStack);
        }
        topStack.push(data);
    }

    public T pop() {
        if(topStack == null) {
            throw new EmptyStackException();
        }
        if(topStack.isEmpty()) {
            topStack = topStack.next;
            return pop();
        }
        return topStack.pop();
    }

    public T peek() {
        if(topStack == null) {
            throw new EmptyStackException();
        }
        if(topStack.isEmpty()) {
            topStack = topStack.next;
            return peek();
        }
        return topStack.peek();
    }

    public boolean isEmpty() {
        return topStack == null || (topStack.next == null && topStack.isEmpty());
    }

    public T popAt(int index) {
        int howManyStacks = 1;
        if(topStack.isEmpty()) {
            throw new EmptyStackException();
        }
        while(topStack.next != null) {
            howManyStacks++;
        }
        int nth = howManyStacks - index;
        if(nth < 0) {
            throw new IndexOutOfBoundsException();
        }
        Stack<T> found = topStack;
        for(int c = 0; c < nth - 1; c++) {
            found = found.next;
        }
        return found.pop();
    }

    static class Stack<T> {
        int currentCapacity = 0;
        StackNode<T> top;
        Stack<T> next;

        Stack(StackNode<T> top, Stack<T> next) {
            this.top = top;
            this.next = next;
        }

        void push(T data) {
            top = new StackNode<>(data, top);
            currentCapacity++;
        }

        T pop() {
            if(isEmpty()) throw new EmptyStackException();
            T data = top.data;
            top = top.next;
            currentCapacity--;
            return data;
        }

        T peek() {
            if(isEmpty()) throw new EmptyStackException();
            return top.data;
        }

        boolean isEmpty() {
            return top == null;
        }

        static class StackNode<T> {
            T data;
            StackNode<T> next;
            StackNode(T d, StackNode<T> next) {
                this.data = d;
                this.next = next;
            }
        }
    }
}
