package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class IntersectionTest {

    @Test
    public void shouldDetectIntersection() {
        // given
        Node<Integer> firstIntersection = Node.of(6);
        Node<Integer> a = Node.createAndLink(
                Node.of(1),
                Node.of(2),
                Node.of(9),
                Node.of(0),
                Node.of(11),
                firstIntersection,
                Node.of(7),
                Node.of(8)
        );
        Node<Integer> b = Node.createAndLink(
                Node.of(3),
                Node.of(4),
                firstIntersection
                // rest of nodes linked with first intersection
        );

        // when
        Node<Integer> intersection = Intersection.intersection(a, b);

        // then
        assertThat(intersection, equalTo(firstIntersection));
    }
}