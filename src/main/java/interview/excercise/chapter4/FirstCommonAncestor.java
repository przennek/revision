package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FirstCommonAncestor {

    public <T> BinaryTreeNode<T> find(BinaryTreeNode<T> root,
                                      BinaryTreeNode<T> a,
                                      BinaryTreeNode<T> b) {
        LinkedList<String> aSeq = genLR(root, a);
        LinkedList<String> bSeq = genLR(root, b);

        if(!aSeq.isEmpty() && !bSeq.isEmpty()) {
            int diff = aSeq.size() - bSeq.size();
            if(diff > 0) {
                for(int i = 0; i < diff; i++)
                    bSeq.add(null);
            } else {
                for(int i = diff; i < 0; i++)
                    aSeq.add(null);
            }
            for(int i = 0; i < aSeq.size(); i++) {
                if(Objects.equals(aSeq.get(i), bSeq.get(i))) {
                    if(Objects.equals(aSeq.get(i), "L")) {
                        if(root.left == a || root.left == b) {
                            return root;
                        }
                        root = root.left;
                    } else {
                        if(root.right == a || root.right == b) {
                            return root;
                        }
                        root = root.right;
                    }
                }
            }
            return root;
        }
        return null;
    }

    private <T> LinkedList<String> genLR(BinaryTreeNode<T> root,
                                         BinaryTreeNode<T> s) {
        LinkedList<String> seq = new LinkedList<>();
        genLR(root, s, seq);
        return seq;
    }

    private <T> List<String> genLR(BinaryTreeNode<T> root,
                                   BinaryTreeNode<T> s,
                                   LinkedList<String> seq) {
        if (root == s) {
            return seq;
        }
        if (root.left != null) {
            seq.add("L");
            if (genLR(root.left, s, seq) != null) {
                return seq;
            }
        }
        if (root.right != null) {
            seq.add("R");
            if (genLR(root.right, s, seq) != null) {
                return seq;
            }
        }
        seq.removeLast();
        return null;
    }
}
