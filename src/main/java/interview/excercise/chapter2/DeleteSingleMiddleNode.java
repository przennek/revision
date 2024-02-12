package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;

public class DeleteSingleMiddleNode {

    public static <T> void deleteSingleLL(Node<T> node) {
        if(node.next != null) {
            node.data = node.next.data;
            if(node.next.next == null) {
                node.next = null;
            } else {
                deleteSingleLL(node.next);
            }
        }
    }

}
