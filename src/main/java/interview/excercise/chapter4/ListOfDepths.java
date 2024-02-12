package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;

import java.util.LinkedList;

public class ListOfDepths {

    public static <T> LinkedList<LinkedList<BinaryTreeNode<T>>> walk(BinaryTreeNode<T> root) {
        LinkedList<LinkedList<BinaryTreeNode<T>>> out = new LinkedList<>();
        LinkedList<BinaryTreeNode<T>> rootLvl = new LinkedList<>();
        rootLvl.add(root);
        out.add(rootLvl);
        walk(out); // mic drop
        return out;
    }

    static <T> void walk(LinkedList<LinkedList<BinaryTreeNode<T>>> l) {
        LinkedList<BinaryTreeNode<T>> nextLvl = new LinkedList<>();
        for (BinaryTreeNode<T> n : l.getLast()) {
            if (n.left != null) {
                nextLvl.add(n.left);
            }
            if (n.right != null) {
                nextLvl.add(n.right);
            }
        }
        if (!nextLvl.isEmpty()) {
            l.add(nextLvl);
            walk(l);
        }
    }
}
