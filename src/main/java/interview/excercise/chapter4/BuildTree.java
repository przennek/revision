package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;

public class BuildTree {

    public static BinaryTreeNode<Integer> buildTree(int[] e) {
        int len = e.length;
        int start = 0;
        int end = len - 1;
        return buildTree(e, start, end);
    }

    private static BinaryTreeNode<Integer> buildTree(int[] e, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(e[mid]);
        root.left = buildTree(e, start, mid - 1);
        root.right = buildTree(e, mid + 1, end);
        return root;
    }

}
