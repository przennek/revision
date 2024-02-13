package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

public class BuildTreePermutations {

    public List<List<Integer>> bstSeq(BinaryTreeNode<Integer> root) {
        List<List<Integer>> seq = bstSequence(root);
        return synthesise(seq);
    }

    public List<List<Integer>> synthesise(List<List<Integer>> acc) {
        List<List<List<Integer>>> perms = new LinkedList<>();
        for (List<Integer> n : acc) {
            perms.add(genPerm(n));
        }
        List<List<Integer>> acc2 = new LinkedList<>();
        for (List<List<Integer>> perm : perms) {
            if(acc2.isEmpty()) {
                acc2.addAll(perm);
            } else {
                List<List<Integer>> acc3 = new LinkedList<>();
                for(List<Integer> p : perm) {
                    for(List<Integer> p2: acc2) {
                        List<Integer> nr = new LinkedList<>();
                        nr.addAll(p2);
                        nr.addAll(p);
                        acc3.add(nr);
                    }
                }
                acc2 = acc3;
            }
        }
        return acc2;
    }

    public List<List<Integer>> bstSequence(BinaryTreeNode<Integer> root) {
        List<BinaryTreeNode<Integer>> ir = List.of(root);
        return bstSequence(ir, new LinkedList<>());
    }

    public List<List<Integer>> bstSequence(List<BinaryTreeNode<Integer>> nr,
                                           List<List<Integer>> acc) {
        List<BinaryTreeNode<Integer>> next = new LinkedList<>();
        for (BinaryTreeNode<Integer> n : nr) {
            if (n.left != null) {
                next.add(n.left);
            }
            if (n.right != null) {
                next.add(n.right);
            }
        }
        List<Integer> a = nr.stream().map(i -> i.data).toList();
        acc.add(a);
        if (next.isEmpty()) {
            return acc;
        } else {
            return bstSequence(next, acc);
        }
    }

    public List<List<Integer>> genPerm(List<Integer> in) {
        List<List<Integer>> out = new LinkedList<>();

        for (Integer i : in) {
            List<Integer> nim = new LinkedList<>();
            for (Integer j : in) {
                if (!j.equals(i)) {
                    nim.add(j);
                }
            }
            if (nim.isEmpty()) {
                return List.of(List.of(i));
            }
            List<List<Integer>> ret = genPerm(nim);
            for (List<Integer> l : ret) {
                List<Integer> nl = new LinkedList<>();
                nl.add(i);
                nl.addAll(l);
                out.add(nl);
            }
        }
        return out;
    }
}
