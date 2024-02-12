package interview.excercise.chapter2.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node<T> {
    public T data;
    public Node<T> next;

    private Node(T data) {
        this.data = data;
    }

    public static <T> Node<T> of(T data) {
        return new Node<>(data);
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(!(other instanceof Node)) {
            return false;
        }
        Node<T> oth = (Node<T>) other;
        return oth.data.equals(this.data);
    }

    @SafeVarargs
    public static <T> Node<T> createAndLink(Node<T>... nodes) {
        if(nodes.length == 0) {
            return null;
        }
        List<Node<T>> nod = new ArrayList<>() {{
            addAll(Arrays.asList(nodes));
        }};
        for (int i = 0; i < nod.size() - 1; i++) {
            nod.get(i).next = nod.get(i + 1);
        }
        return nod.get(0);
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> out = new ArrayList<>();
        Node<T> head = this;
        while (head != null) {
            out.add(head.data);
            head = head.next;
        }
        return out;
    }
}
