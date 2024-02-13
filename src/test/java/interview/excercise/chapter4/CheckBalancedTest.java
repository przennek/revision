package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import static interview.excercise.chapter4.CheckBST.checkBST;

class CheckBalancedTest {

    @Test
    public void shouldTestBalancedEx1() {
        // given
        //       1
        //      / \
        //     2   3
        //    /   / \
        //   4   4   4
        //  / \
        // 5   6
        //      \
        //       9

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);

        root.left = n2;
        root.right = n3;

        BinaryTreeNode<Integer> n41 = new BinaryTreeNode<>(4);

        n2.left = n41;

        BinaryTreeNode<Integer> n42 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n43 = new BinaryTreeNode<>(4);
        n3.left = n42;
        n3.right = n43;

        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> n9 = new BinaryTreeNode<>(9);

        n41.left = n5;
        n41.right = n6;
        n6.right = n9;

        // when
        boolean isBalanced = CheckBalanced.isBalanced(root);

        // then
        assert !isBalanced;

        // when 4.5
        boolean bst = checkBST(root);

        // then
        assert !bst;

        // when 4.8
        FirstCommonAncestor fca = new FirstCommonAncestor();
        BinaryTreeNode<Integer> a1 = fca.find(root, n42, n43);

        // then
        assert a1 == n3;

        // when
        BinaryTreeNode<Integer> a2 = fca.find(root, n9, n6);

        // then
        assert a2 == n41;

        // when
        BinaryTreeNode<Integer> a3 = fca.find(root, n9, n43);

        // then
        assert a3 == root;
    }
}