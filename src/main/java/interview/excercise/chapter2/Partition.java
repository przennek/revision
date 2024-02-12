package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;

public class Partition {
    public static <T extends Comparable<T>> Node<T> partition(Node<T> head, T p) {
        Node<T> current = head;
        Node<T> next = head.next;

        while (next != null) {
            if (next.data.compareTo(p) < 0) {
                deleteNext(current);
                head = addFirst(head, next);
                next = current.next;
            } else {
                current = next;
                next = current.next;
            }
        }
        return head;
    }

    private static <T> void deleteNext(Node<T> parent) {
        if (parent.next != null) {
            parent.next = parent.next.next;
        }
    }

    private static <T> Node<T> addFirst(Node<T> head, Node<T> newHead) {
        newHead.next = head;
        return newHead;
    }
}
