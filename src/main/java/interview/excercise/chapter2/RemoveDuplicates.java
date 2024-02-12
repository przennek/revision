package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;

public class RemoveDuplicates {

    public static <T> void deleteDuplicates(Node<T> head) {
        Node<T> current = head;
        while(current.next != null) {
            Node<T> previous = current;
            current = current.next;
            if(head.equals(current)) {
                previous.next = current.next;
                current = previous;
            }
        }
        if(head.next != null) {
            deleteDuplicates(head.next);
        }
    }
}
