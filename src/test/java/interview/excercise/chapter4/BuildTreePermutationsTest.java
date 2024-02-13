package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildTreePermutationsTest {

    @Test
    public void genPerm() {
        // given
        List<Integer> in = List.of(1, 2, 3, 4);

        // when
        List<List<Integer>> perms = new BuildTreePermutations().genPerm(in);

        // then
        assert perms.size() == 24;
    }

    @Test
    public void sequencesTest() {
        // given
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n1l = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n1r = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> n2ll = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2lr = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n2rl = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> n2rr = new BinaryTreeNode<>(8);


        root.left = n1l;
        root.right = n1r;

        n1l.right = n2lr;
        n1l.left = n2ll;

        n1r.right = n2rr;
        n1r.left = n2rl;

        // when
        List<List<Integer>> sequences = new BuildTreePermutations().bstSeq(root);

        // then
        assert sequences.size() == 48;
    }

}