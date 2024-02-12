package interview;

import interview.datastructures.core.BinaryTree;
import interview.datastructures.core.LinkedList;
import interview.datastructures.core.Tree;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TreeTest {

    @Test
    public void shouldGoThroughDepthFirst() {
        // given
        Tree<Integer> exampleTree = createExampleTree();
        //           0
        //      /    |       \
        //    1      2        3
        //   / \            /  |  \
        //  4   5           7   8   9
        // /                |      /\
        // 10              11    12  13

        // when
        LinkedList<Integer> output = new LinkedList<>();
        exampleTree.dfTraversal(n -> {
            output.add(n.getValue());
            return Optional.empty();
        });

        // then
        assertThat(output, equalTo(new LinkedList<>(0, 1, 4, 10, 5, 2, 3, 7, 11, 8, 9, 12, 13)));

    }

    @Test
    public void shouldFindDepthFirst() {
        // given
        Tree<Integer> exampleTree = createExampleTree();
        //           0
        //      /    |       \
        //    1      2        3
        //   / \            /  |  \
        //  4   5           7   8   9
        // /                |      /\
        // 10              11    12  13

        // when
        Optional<Tree.Node<Integer>> found = exampleTree
                .dfTraversal(node -> node.getValue().equals(8) ?
                        Optional.of(node) :
                        Optional.empty()
                );

        // then
        assertThat(found.map(Tree.Node::getValue), equalTo(Optional.of(8)));

    }

    @Test
    public void shouldGoThroughBreadthFirst() {
        // given
        Tree<Integer> exampleTree = createExampleTree();
        //           0
        //      /    |       \
        //    1      2        3
        //   / \            /  |  \
        //  4   5           7   8   9
        // /                |      /\
        // 10              11    12  13

        // when
        LinkedList<Integer> output = new LinkedList<>();
        exampleTree.bfTraversal(n -> {
            output.add(n.getValue());
            return Optional.empty();
        });

        // then
        assertThat(output, equalTo(new LinkedList<>(0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13)));
    }

    @Test
    public void shouldFindBreadthFirst() {
        // given
        Tree<Integer> exampleTree = createExampleTree();
        //           0
        //      /    |       \
        //    1      2        3
        //   / \            /  |  \
        //  4   5           7   8   9
        // /                |      /\
        // 10              11    12  13

        // when
        Optional<Tree.Node<Integer>> found = exampleTree
                .bfTraversal(node -> node.getValue().equals(3) ?
                        Optional.of(node) :
                        Optional.empty()
                );

        // then
        assertThat(found.map(Tree.Node::getValue), equalTo(Optional.of(3)));
    }

    @Test
    public void shouldSearchBinaryTree() {
        // given
        BinaryTree<Integer> integerTree = BinaryTree.construct(new LinkedList<>(3, 2, 1, 7, 6, 5, 8));

        // when
        System.out.println();
    }

    private static Tree<Integer> createExampleTree() {

        return Tree.<Integer>builder()
                .value(0)
                .leaf(Tree.<Integer>builder()
                        .value(1)
                        .leaf(Tree.<Integer>builder()
                                .value(4)
                                .leaf(Tree.<Integer>builder()
                                        .value(10)
                                        .buildNode()
                                )
                                .buildNode()
                        )
                        .leaf(Tree.<Integer>builder()
                                .value(5)
                                .buildNode()
                        )
                        .buildNode()
                )
                .leaf(Tree.<Integer>builder()
                        .value(2)
                        .buildNode()
                )
                .leaf(Tree.<Integer>builder()
                        .value(3)
                        .leaf(Tree.<Integer>builder()
                                .value(7)
                                .leaf(Tree.<Integer>builder()
                                        .value(11)
                                        .buildNode()
                                )
                                .buildNode()
                        )
                        .leaf(Tree.<Integer>builder()
                                .value(8)
                                .buildNode()
                        )
                        .leaf(Tree.<Integer>builder()
                                .value(9)
                                .leaf(Tree.<Integer>builder()
                                        .value(12)
                                        .buildNode()
                                )
                                .leaf(Tree.<Integer>builder()
                                        .value(13)
                                        .buildNode()

                                )
                                .buildNode()

                        )
                        .buildNode()
                )
                .buildTree();
    }
}
