package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;

public class FindKth {

    public static class IndexNode<T> {
        int index;
        Node<T> node;

        public IndexNode(int index, Node<T> node) {
            this.index = index;
            this.node = node;
        }
    }

    public static <T> Node<T> findKthToLast(Node<T> head, int k) {
        IndexNode<T> kth = findKth(head, k);
        return k == kth.index ? kth.node : null;
    }

    private static <T> IndexNode<T> findKth(Node<T> head, int k) {
        if(head.next == null) {
            return new IndexNode<>(1, head);
        }
        IndexNode<T> kth = findKth(head.next, k);
        if(kth.index == k) {
            return kth;
        }

        return new IndexNode<>(kth.index + 1, head);
    }
}
