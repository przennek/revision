package interview.datastructures;

import interview.datastructures.core.BinaryTree;
import interview.datastructures.core.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BinaryTreeTest {

    @Test
    public void invertTest() {
        // given
        BinaryTree<Integer> tree = BinaryTree.construct(new LinkedList<>(1, 2, 3, 4, 5, 6, 7, 8, 9));
        LinkedList<Integer> notInvertedPayload = new LinkedList<>();
        tree.bfTraversal(it -> {
            notInvertedPayload.add(it.getValue());
            return Optional.empty();
        });

        // when
        tree.invert();

        // then
        LinkedList<Integer> invertedPayload = new LinkedList<>();
        tree.bfTraversal(it -> {
            invertedPayload.add(it.getValue());
            return Optional.empty();
        });

        assertThat(notInvertedPayload, equalTo(new LinkedList<>(5, 3, 8, 2, 4, 7, 9, 1, 6)));
        assertThat(invertedPayload, equalTo(new LinkedList<>(5, 8, 3, 9, 7, 4, 2, 6, 1)));
    }
}