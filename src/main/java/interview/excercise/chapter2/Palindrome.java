package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;

public class Palindrome {

    public static class NodeSize<T> {
        public NodeSize(Node<T> head, int size) {
            this.head = head;
            this.size = size;
        }
        Node<T> head;
        int size;
    }

    public static <T> boolean isPalindrome(Node<T> head) {
        NodeSize<T> data = get(head);
        Node<T> rev = data.head;
        int size = data.size;
        for(int i = 0; i < size /2; i++) {
            if(!rev.data.equals(head.data)) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

    public static <T> NodeSize<T> get(Node<T> head) {
        head = findMid(head);
        Node<T> c = head;
        Node<T> next = head.next;
        int count = 0;
        while(next != null) {
            Node<T> nextNext = next.next;
            next.next = c;
            c = next;
            next = nextNext;
            count++;
        }
        return new NodeSize<>(c, count);
    }

    public static <T> Node<T> findMid(Node<T> head) {
        Node<T> jumper = head;
        while(jumper.next != null && jumper.next.next != null) {
            jumper = jumper.next.next;
            head = head.next;
        }
        return head;
    }
}
