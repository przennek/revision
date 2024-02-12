package interview.excercise.chapter4;

import interview.excercise.chapter4.datastructures.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static interview.excercise.chapter4.CheckBST.checkBST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TreeTest {

    @Test
    public void multipleExerciseTest() {
        // given
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        //              5
        //            /   \
        //           2     7
        //          / \   / \
        //         1   3 6   8
        //              \     \
        //               4     9

        // when 4.2
        BinaryTreeNode<Integer> out = BuildTree.buildTree(a);


        // then
        assert out.data.equals(5);
        assert out.left.data.equals(2);
        assert out.right.data.equals(7);
        assert out.left.left.data.equals(1);
        assert out.left.right.data.equals(3);
        assert out.left.right.right.data.equals(4);
        assert out.right.left.data.equals(6);
        assert out.right.right.data.equals(8);
        assert out.right.right.right.data.equals(9);

        // when 4.3
        LinkedList<LinkedList<BinaryTreeNode<Integer>>> depthList = ListOfDepths.walk(out);

        // map it to make assertions easier
        List<List<Integer>> alist = depthList.stream().map(dl -> dl.stream()
                .map(it -> it.data)
                .collect(Collectors.toList())
        ).toList();

        // then
        assertThat(alist.get(0), equalTo(List.of(5)));
        assertThat(alist.get(1), equalTo(List.of(2, 7)));
        assertThat(alist.get(2), equalTo(List.of(1, 3, 6, 8)));
        assertThat(alist.get(3), equalTo(List.of(4, 9)));

        // when 4.5
        boolean bst = checkBST(out);

        // then
        assert bst;
    }
}