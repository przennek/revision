package interview.excercise.chapter3;


import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AnimalShelter {
    static class Cat extends A {

    }
    static class Dog extends A {

    }
    abstract static class A {

    }

    LinkedList<A> animals = new LinkedList<>();

    void enqueue(A animal) {
        animals.add(animal);
    }

    A dequeue() {
        if(animals.isEmpty()) {
            throw new NoSuchElementException();
        }
        return animals.removeFirst();
    }

    Dog dequeueDog() {
        int c = 0;
        for(A a : animals) {
            if(animals.get(c) instanceof Dog) return (Dog) animals.remove(c);
            c++;
        }
        throw new NoSuchElementException();
    }
}
