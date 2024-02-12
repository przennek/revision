package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static interview.excercise.chapter2.SumLists.sumListInOrd;
import static interview.excercise.chapter2.SumLists.sumListsRevOrd;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SumListsTest {

    @Test
    public void reverseSimpleAddTest() {
        // given
        Node<Integer> a = Node.createAndLink(
                Node.of(9),
                Node.of(9),
                Node.of(1)
        );

        Node<Integer> b = Node.createAndLink(
                Node.of(1),
                Node.of(1),
                Node.of(3)
        );

        // 199 + 311 = 510

        // when
        Node<Integer> out = sumListsRevOrd(a, b);

        // then
        assertThat(out.toArrayList(), equalTo(List.of(0, 1, 5)));
    }

    @Test
    public void reverseAddTest() {
        // given
        Node<Integer> a = Node.createAndLink(
                Node.of(9),
                Node.of(9),
                Node.of(9)
        );

        Node<Integer> b = Node.createAndLink(
                Node.of(1),
                Node.of(1),
                Node.of(3)
        );

        // 999 + 311 = 1310

        // when
        Node<Integer> out = sumListsRevOrd(a, b);

        // then
        assertThat(out.toArrayList(), equalTo(List.of(0, 1, 3, 1)));
    }

    @Test
    public void simpleAddTest() {
        // given
        Node<Integer> a = Node.createAndLink(
                Node.of(9),
                Node.of(9),
                Node.of(9)
        );

        Node<Integer> b = Node.createAndLink(
                Node.of(1),
                Node.of(1),
                Node.of(3)
        );

        // 999 + 113 = 1112
        // when
        Node<Integer> out = sumListInOrd(a, b);

        // then
        assertThat(out.toArrayList(), equalTo(List.of(1, 1, 1, 2)));
    }
}