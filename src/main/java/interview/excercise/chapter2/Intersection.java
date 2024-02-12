package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;

public class Intersection {
    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> c = head;
        Node<T> next = head.next;
        c.next = null;

        while(next != null) {
            Node<T> nextNext = next.next;
            next.next = c;
            c = next;
            next = nextNext;
        }
        return c;
    }

    public static <T> Node<T> findLast(Node<T> head) {
        while(head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static <T> int size(Node<T> head) {
        int c = 0;
        while(head.next != null) {
            head = head.next;
            c++;
        }
        return c;
    }

    public static <T> Node<T> intersection(Node<T> a, Node<T> b) {
        Node<T> lastA = findLast(a);
        Node<T> lastB = findLast(b);

        if(lastA == lastB) {
            a = reverse(a);
            // b = b'
            int sb = size(b);
            int sa = size(a);
            int diff = 0;
            Node<T> longer, shorter;
            if(sa > sb) {
                longer = a;
                shorter = b;
                diff = sa - sb;
            } else {
                longer = b;
                shorter = a;
                diff = sb - sa;
            }
            for(int i = 0; i < diff; i++) {
                longer = longer.next;
            }

            while(longer.next != null) {
                longer = longer.next;
                shorter = shorter.next;
                if(longer == shorter) {
                    return longer;
                }
            }
            return null;
        }
        return null;
    }
}
