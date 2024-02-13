package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class IsSubtree {

    public <T extends Comparable<T>> boolean checkSubtree(BinaryTreeNode<T> t1Root,
                                    BinaryTreeNode<T> t2Root) {
        int t1d = findDepth(t1Root);
        int t2d = findDepth(t2Root);
        List<BinaryTreeNode<T>> t1Start = skipThrough(List.of(t1Root), t1d - t2d);
        return checkSubtree(t1Start, t2Root, t2d);
    }

    private <T extends Comparable<T>> boolean checkSubtree(List<BinaryTreeNode<T>> t1Start,
                                     BinaryTreeNode<T> t2Root, int t2d) {
        for(BinaryTreeNode<T> n : t1Start) {
            if(n.data.compareTo(t2Root.data) == 0) {
                if(checkTree(List.of(n), List.of(t2Root), t2d)) {
                    return true;
                }
            }
        }
        return false;
    }

    private <T extends Comparable<T>> boolean checkTree(List<BinaryTreeNode<T>> t1,
                                                List<BinaryTreeNode<T>> t2,
                                                int d) {
        List<BinaryTreeNode<T>> nextt1 = new LinkedList<>();
        List<BinaryTreeNode<T>> nextt2 = new LinkedList<>();

        if(t1.size() != t2.size()) {
            return false;
        }

        for(int i = 0; i < t1.size(); i++) {
            T val1 = t1.get(i) == null ? null : t1.get(i).data;
            T val2 = t2.get(i) == null ? null : t2.get(i).data;
            if(!Objects.equals(val1, val2)) {
                return false;
            }
            if(t1.get(i) != null) {
                nextt1.add(t1.get(i).left);
                nextt1.add(t1.get(i).right);
                nextt2.add(t2.get(i).left);
                nextt2.add(t2.get(i).right);
            }
        }

        if(d == 0) {
            return true;
        }

        return checkTree(nextt1, nextt2, d - 1);
    }

    private <T> List<BinaryTreeNode<T>> skipThrough(List<BinaryTreeNode<T>> s, int skip) {
        List<BinaryTreeNode<T>> next = new LinkedList<>();
        for (BinaryTreeNode<T> n : s) {
            if (n.left != null) next.add(n.left);
            if (n.right != null) next.add(n.right);
        }
        if (skip == 1) {
            return next;
        }
        return skipThrough(next, skip - 1);
    }

    private int findDepth(BinaryTreeNode<?> root) {
        int d = 0;
        if (root == null) {
            return d;
        }
        return findDepth(root, d + 1);
    }

    private int findDepth(BinaryTreeNode<?> root, int d) {
        int max = d;
        if (root.left != null) {
            max = findDepth(root.left, d + 1);
        }
        if (root.right != null) {
            int rmax = findDepth(root.right, d + 1);
            max = max > rmax ? max : rmax;
        }
        return max;
    }
}
