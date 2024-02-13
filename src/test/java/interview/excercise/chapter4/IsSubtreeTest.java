package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSubtreeTest {

    @Test
    public void shouldDetectSubtree() {
        // given
        BinaryTreeNode<Integer> t1Root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> t1l = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> t1r = new BinaryTreeNode<>(3);

        BinaryTreeNode<Integer> t1ll = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> t1lr = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> t1rl = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> t1rr = new BinaryTreeNode<>(7);

        BinaryTreeNode<Integer> t1lll = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> t1llr = new BinaryTreeNode<>(9);

        BinaryTreeNode<Integer> t1lrl = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> t1lrr = new BinaryTreeNode<>(11);

        BinaryTreeNode<Integer> t1rll = new BinaryTreeNode<>(12);
        BinaryTreeNode<Integer> t1rlr = new BinaryTreeNode<>(13);

        BinaryTreeNode<Integer> t1rrl = new BinaryTreeNode<>(14);
        BinaryTreeNode<Integer> t1rrr = new BinaryTreeNode<>(15);

        t1Root.right = t1r;
        t1Root.left = t1l;

        t1r.right = t1rr;
        t1r.left = t1rl;

        t1l.right = t1lr;
        t1l.left = t1ll;

        t1ll.right = t1llr;
        t1ll.left = t1lll;

        t1lr.right = t1lrr;
        t1lr.left = t1lrl;

        t1rl.left = t1rll;
        t1rl.right = t1rlr;

        t1rr.left = t1rrl;
        t1rr.right = t1rrr;

        //              5
        //         /        \
        //        2           3
        //      /   \        /  \
        //     4     5      6    7
        //    / \   /  \   / \  / \
        //   8   9 10  11 12 13 14 15

        BinaryTreeNode<Integer> t2Root = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> t2l = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> t2r = new BinaryTreeNode<>(9);
        t2Root.right = t2r;
        t2Root.left = t2l;

        // when
        boolean subtree = new IsSubtree().checkSubtree(t1Root, t2Root);

        // then
        assert subtree;
    }

}