package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

public class CheckBST {

    public static <T extends Comparable<T>> boolean checkBST(BinaryTreeNode<T> root) {
        return checkBST(List.of(root));
    }

    private static <T extends Comparable<T>> boolean checkBST(List<BinaryTreeNode<T>> nodes) {
        List<BinaryTreeNode<T>> nextRow = new LinkedList<>();
        for(BinaryTreeNode<T> n : nodes) {
            if(n.left != null) {
                nextRow.add(n.left);
                T max = findMax(n.left);
                if(max.compareTo(n.data) > 0) {
                    return false;
                }
            }
            if(n.right != null) {
                nextRow.add(n.right);
                T min = findMin(n.right);
                if(min.compareTo(n.data) <= 0) {
                    return false;
                }
            }
        }
        if(nextRow.isEmpty()) {
            return true;
        }
        return checkBST(nextRow);
    }

    private static <T extends Comparable<T>> T findMin(BinaryTreeNode<T> root) {
        T min = null;
        if(root.left != null) {
            min = findMin(root.left);
        }
        if(root.right != null) {
            T c = findMin(root.right);
            if(min == null) {
                min = c;
            }
            min = min.compareTo(c) > 0 ? c : min;
        }
        if(min == null) {
            return root.data;
        }
        return min.compareTo(root.data) < 0 ? min : root.data;
    }

    private static <T extends Comparable<T>> T findMax(BinaryTreeNode<T> root) {
        T max = null;
        if(root.left != null) {
            max = findMax(root.left);
        }
        if(root.right != null) {
            T c = findMax(root.right);
            if(max == null) {
                max = c;
            }
            max = max.compareTo(c) < 0 ? c : max;
        }
        if(max == null) {
            return root.data;
        }
        return max.compareTo(root.data) > 0 ? max : root.data;
    }
}
