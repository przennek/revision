package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static interview.excercise.chapter2.RemoveDuplicates.deleteDuplicates;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RemoveDuplicatesTest {

    @Test
    public void shouldRemoveDuplicates() {
        // given
        Node<Integer> head = Node.createAndLink(
                Node.of(1),
                Node.of(2),
                Node.of(3),
                Node.of(3),
                Node.of(3),
                Node.of(4),
                Node.of(5)
        );

        // when
        deleteDuplicates(head);

        // then
        assertThat(head.toArrayList(), equalTo(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    public void shouldRemoveDuplicates2() {
        // given
        Node<Integer> head = Node.createAndLink(
                Node.of(1),
                Node.of(2),
                Node.of(3),
                Node.of(3),
                Node.of(4),
                Node.of(5),
                Node.of(3)
        );

        // when
        deleteDuplicates(head);

        // then
        assertThat(head.toArrayList(), equalTo(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    public void shouldNotRemove() {
        // given
        Node<Integer> head = Node.createAndLink(
                Node.of(1),
                Node.of(2),
                Node.of(3),
                Node.of(4),
                Node.of(5)
        );

        // when
        deleteDuplicates(head);

        // then
        assertThat(head.toArrayList(), equalTo(List.of(1, 2, 3, 4, 5)));
    }
}