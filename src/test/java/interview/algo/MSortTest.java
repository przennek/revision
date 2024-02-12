package interview.algo;

import interview.datastructures.core.LinkedList;
import interview.datastructures.interf.List;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MSortTest {

    @Test
    public void shouldSort() {
        // given
        LinkedList<Integer> toBeSorted = new LinkedList<>(3, 4, 5, 6, 1, 1, 2, 3);

        // when
        List<Integer> sorted = MSort.sort(toBeSorted);

        // then
        assertThat(sorted, equalTo(new LinkedList<>(1, 1, 2, 3, 3, 4, 5, 6)));
    }

}