package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;

import java.util.LinkedList;

public class CheckBalanced {

    public static <T> boolean isBalanced(BinaryTreeNode<T> root) {
        LinkedList<BinaryTreeNode<T>> l = new LinkedList<>();
        l.add(root);
        return isBalanced(l);
    }

    private static <T> boolean isBalanced(LinkedList<BinaryTreeNode<T>> l) {
        Integer min = null;
        Integer max = null;
        LinkedList<BinaryTreeNode<T>> nl = new LinkedList<>();
        for(BinaryTreeNode<T> n : l) {
            int d = findDepth(n);
            if(min == null || min > d) {
                min = d;
            }
            if(max == null || max < d) {
                max = d;
            }
            if(max - min >= 2) {
                return false;
            }
            if(n.left != null) nl.add(n.left);
            if(n.right != null) nl.add(n.right);
        }

        if(nl.isEmpty()) {
            return true;
        }

        return isBalanced(nl);
    }

    private static <T> int findDepth(BinaryTreeNode<T> root) {
        return findDepth(root, 0);
    }

    private static <T> int findDepth(BinaryTreeNode<T> root, int c) {
        int rc = c;
        int lc = c;
        if(root.left != null) {
            lc = findDepth(root.left, c + 1);
        }
        if(root.right != null) {
            rc = findDepth(root.right, c + 1);
        }
        return lc > rc ? lc : rc;
    }
}
