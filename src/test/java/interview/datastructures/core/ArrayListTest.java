package interview.datastructures.core;

import interview.datastructures.interf.List;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ArrayListTest {

    @Test
    public void shouldAdd() {
        // given
        ArrayList<Integer> intsList = new ArrayList<>();

        // when
        intsList.add(1);
        intsList.add(2);
        intsList.add(3);
        intsList.addFirst(0);

        // then
        assertThat(intsList, equalTo(new ArrayList<>(0, 1, 2, 3)));
    }

    @Test
    public void shouldAddAll() {
        // given
        ArrayList<Integer> intsList = new ArrayList<>(1, 2, 3);

        // when
        intsList.addAll(new ArrayList<>(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        // then
        assertThat(intsList,
                equalTo(new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)));
    }

    @Test
    public void getSetEtcTest() {
        // given
        ArrayList<String> list = new ArrayList<>("Test");

        // when
        list.set("Not a test", 0);

        // then
        assertThat(list.get(0), equalTo("Not a test"));
    }

    @Test
    public void removeTest() {
        // given
        ArrayList<Integer> intsList = new ArrayList<>(111, 222, 33, 44, 55);

        // when
        int removed = intsList.remove(222).get();
        Optional<Integer> notRemoved = intsList.remove(1123);

        // then
        assertThat(intsList, equalTo(new ArrayList<>(111, 33, 44, 55)));
        assertThat(removed, equalTo(222));
        assertThat(notRemoved, equalTo(Optional.empty()));
        assertThat(intsList.isEmpty(), equalTo(false));
    }

    @Test
    public void removeTestLastElement() {
        // given
        ArrayList<Integer> intsList = new ArrayList<>(111, 222);

        // when
        int removed = intsList.remove(222).get();

        // then
        assertThat(intsList, equalTo(new ArrayList<>(111)));
        assertThat(removed, equalTo(222));
    }

    @Test
    public void removeTestFirst() {
        // given
        ArrayList<Integer> intsList = new ArrayList<>(111, 222);

        // when
        int removed = intsList.remove(111).get();

        // then
        assertThat(intsList, equalTo(new ArrayList<>(222)));
        assertThat(removed, equalTo(111));
        intsList.remove(222);
        assertThat(intsList.isEmpty(), equalTo(true));
    }

    @Test
    public void shouldSplit() {
        // given
        ArrayList<Integer> list = new ArrayList<>(1, 2, 3, 4, 5);

        // when
        SPair<List<Integer>> split = list.split(2);
        List<Integer> left = split.getLeft();
        List<Integer> right = split.getRight();

        // then
        assertThat(left, equalTo(new ArrayList<>(1, 2, 3)));
        assertThat(right, equalTo(new ArrayList<>(4, 5)));
    }
}