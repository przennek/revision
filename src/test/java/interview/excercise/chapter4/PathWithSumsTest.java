package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathWithSumsTest {

    @Test
    public void shouldReturnPathsWithSums() {
        // given
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> l = new BinaryTreeNode<>(-1);
        BinaryTreeNode<Integer> r = new BinaryTreeNode<>(4);

        BinaryTreeNode<Integer> lr = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> ll = new BinaryTreeNode<>(-1);

        BinaryTreeNode<Integer> rl = new BinaryTreeNode<>(-6);
        BinaryTreeNode<Integer> rr = new BinaryTreeNode<>(8);

        BinaryTreeNode<Integer> rrr = new BinaryTreeNode<>(-9);

        root.right = r;
        root.left = l;

        r.right = rr;
        r.left = rl;

        l.right = lr;
        l.left = ll;

        rr.right = rrr;

        //            5
        //          /   \
        //        -1     4
        //       /  \   /  \
        //     -1   3  -6   8
        //                   \
        //                    9

        // when
        int sums = new PathWithSums().pathWithSums(root, 3);

        // then
        assert sums == 4;
    }

}