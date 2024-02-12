package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FindKthToLastTest {
    @Test
    public void shouldFindKth() {
        // given
        Node<Integer> head = Node.createAndLink(
                Node.of(10),
                Node.of(11),
                Node.of(12),
                Node.of(13),
                Node.of(14),
                Node.of(15)
        );

        // when
        Node<Integer> kth = FindKth.findKthToLast(head, 3);
        Node<Integer> notFound = FindKth.findKthToLast(head, 666);

        // then
        assertThat(kth, equalTo(Node.of(13)));
        assertThat(notFound, equalTo(null));
    }
}