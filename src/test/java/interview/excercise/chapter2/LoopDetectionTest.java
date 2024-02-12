package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class LoopDetectionTest {

    @Test
    public void shouldDetectLoop() {
        // given
        Node<Integer> tail = Node.of(5);
        Node<Integer> loop = Node.of(3);
        Node<Integer> head = Node.createAndLink(
                Node.of(1),
                Node.of(3),
                Node.of(2),
                loop,
                Node.of(4),
                tail
        );

        tail.next = loop;

        // when
        Node<Integer> out = LoopDetection.loop(head);

        // then
        assert out == loop;
    }
}