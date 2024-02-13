package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathWithSums {

    public int pathWithSums(BinaryTreeNode<Integer> root, int ssum) {
        return pathWithSums(root, new LinkedList<>(), 0, ssum);
    }

    private int pathWithSums(BinaryTreeNode<Integer> n, List<Integer> sums, int c, int ssum) {
        List<Integer> nextSums = new LinkedList<>();
        for(int i = 0; i < sums.size(); i++) {
            int ns = sums.get(i) + n.data;
            if(ns == ssum) {
                c++;
            }
            nextSums.add(ns);
        }
        nextSums.add(n.data);
        if(n.data == ssum) {
            c++;
        }
        if(n.left != null) {
            c = pathWithSums(n.left, nextSums, c, ssum);
        }
        if(n.right != null) {
            c = pathWithSums(n.right, nextSums, c, ssum);
        }
        return c;
    }
}
