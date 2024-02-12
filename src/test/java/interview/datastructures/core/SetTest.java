package interview.datastructures.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SetTest {

    @Test
    public void shouldPut() {
        // given
        Set<Integer> set = new Set<>();

        // when
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);

        // then
        assertThat(set, equalTo(new Set<>(1, 2, 3)));
        assertThat(set.isEmpty(), equalTo(false));
        assertThat(set.contains(3), equalTo(true));
        assertThat(set.contains(4), equalTo(false));
    }

    @Test
    public void shouldPutAndResize() {
        // given
        Set<Integer> set = new Set<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // when
        set.add(11);
        set.add(11);
        set.add(11);
        set.add(12);
        set.add(12);
        set.add(12);
        set.add(13);
        set.add(13);
        set.add(13);

        // then
        assertThat(set, equalTo(new Set<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)));
        assertThat(set.isEmpty(), equalTo(false));
    }

    @Test
    public void shouldRemove() {
        // given
        Set<Integer> set = new Set<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        // when
        for(int i = 1; i < 13; i++) {
            set.remove(i);
        }

        // then
        assertThat(set, equalTo(new Set<>()));
        assertThat(set.isEmpty(), equalTo(true));
    }
}