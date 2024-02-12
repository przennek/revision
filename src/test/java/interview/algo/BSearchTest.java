package interview.algo;

import interview.datastructures.core.LinkedList;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BSearchTest {

    @Test
    public void shouldFind() {
        // given
        LinkedList<Integer> ints = new LinkedList<>(5, 6, 7, 8, 1, 2, 3, 4);

        // when
        boolean found = BSearch.bSearch(ints, 4);

        // then
        assertThat(found, equalTo(true));
    }

    @Test
    public void shouldNotFind() {
        // given
        LinkedList<Integer> ints = new LinkedList<>(5, 6, 7, 8, 1, 2, 3, 4);

        // when
        boolean found = BSearch.bSearch(ints, 44);

        // then
        assertThat(found, equalTo(false));
    }
}