package interview.algo;

import interview.datastructures.core.LinkedList;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class QSortTest {

    @Test
    public void shouldSort() {
        // given
        LinkedList<Integer> ll = new LinkedList<>(8, 2, 4, 7, 1, 3, 9, 6, 5);

        // when
        QSort.sort(ll);

        // then
        assertThat(ll, equalTo(new LinkedList<>(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    @Test
    public void shouldPivot() {
        // given
        LinkedList<Integer> ll = new LinkedList<>(8, 2, 4, 7, 1, 3, 9, 6, 5);

        // when
        QSort.pivot(ll, 0, ll.size());

        // then
        assertThat(ll.get(4), equalTo(5));
    }

    @Test
    public void shouldPivot2() {
        // given
        LinkedList<Integer> ll = new LinkedList<>(0, 1, 4, 5, 2, 3, 0);

        // when
        QSort.pivot(ll, 1, ll.size() - 1);

        // then
        ll.print();
        assertThat(ll.get(3), equalTo(3));
    }

    @Test
    public void shouldPivot3() {
        // given
        LinkedList<Integer> ll = new LinkedList<>(1, 4, 5, 2, 3);

        // when
        QSort.pivot(ll, 0, ll.size());

        // then
        ll.print();
        assertThat(ll.get(2), equalTo(3));
    }
}