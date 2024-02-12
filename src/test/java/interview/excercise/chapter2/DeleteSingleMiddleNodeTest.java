package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DeleteSingleMiddleNodeTest {
    @Test
    public void shouldDelete() {
        // given
        Node<Integer> head = Node.createAndLink(
                Node.of(1),
                Node.of(2),
                Node.of(3),
                Node.of(4),
                Node.of(5)
        );

        // when
        DeleteSingleMiddleNode.deleteSingleLL(head.next.next); // 3

        // then
        assertThat(head.toArrayList(), equalTo(List.of(1, 2, 4, 5)));
    }
}