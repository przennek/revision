package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;

public class SumLists {

    public static Node<Integer> sumListInOrd(Node<Integer> a, Node<Integer> b) {
        int lena = len(a);
        int lenb = len(b);
        Node<Integer> longer, shorter;
        int diff = 0, longerSize = 0;
        if (lena > lenb) {
            longer = a;
            shorter = b;
            diff = lena - lenb;
            longerSize = lena;
        } else {
            longer = b;
            shorter = a;
            diff = lenb - lena;
            longerSize = lenb;
        }
        for (int i = 0; i < diff; i++) {
            Node<Integer> newHead = Node.of(0);
            newHead.next = shorter;
            shorter = newHead;
        }

        Node<Integer> nextS = shorter;
        Node<Integer> nextL = longer;

        int[] carry = new int[longerSize];
        int pos = 0;

        while (nextL != null) {
            int sum = nextL.data + nextS.data;
            if (sum > 9) {
                carry[pos] = 1;
                sum = sum % 10;
            }
            pos++;
            nextL.data = sum;
            nextL = nextL.next;
            nextS = nextS.next;
        }

        Node<Integer> it = longer;
        for (int i = 0; i < longerSize - 1; i++) {
            if (i == 0 && carry[i] == 1) {
                longer = Node.of(1);
                longer.next = it;
            }
            it.data += carry[i];
            it = it.next;
        }

        return longer;
    }

    public static Node<Integer> sumListsRevOrd(Node<Integer> a, Node<Integer> b) {
        int lena = len(a);
        int lenb = len(b);

        Node<Integer> longer, shorter;
        if (lena > lenb) {
            longer = a;
            shorter = b;
        } else {
            longer = b;
            shorter = a;
        }

        Node<Integer> nextS = shorter;
        Node<Integer> nextL = longer, lastL = longer;
        int carry = 0;
        while (nextL != null) {
            int oth = nextS != null ? nextS.data : 0;
            int sum = carry + nextL.data + oth;
            carry = 0;
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            }
            nextL.data = sum;
            lastL = nextL;
            nextL = nextL.next;
            nextS = nextS != null ? nextS.next : null;
        }
        if (carry != 0) {
            lastL.next = Node.of(carry);
        }
        return longer;
    }

    private static <T> int len(Node<T> head) {
        int count = 0;
        if (head != null) {
            count = 1;
            while (head.next != null) {
                count++;
                head = head.next;
            }
        }
        return count;
    }

}
