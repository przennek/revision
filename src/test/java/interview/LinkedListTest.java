package interview;

import interview.datastructures.core.LinkedList;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LinkedListTest {

    @Test
    public void shouldReturnSize() {
        // given
        LinkedList<String> in4 = new LinkedList<>("aa", "bb", "cc", "dd");
        LinkedList<String> in0 = new LinkedList<>();
        LinkedList<String> in1 = new LinkedList<>("Hello there");

        // when
        Integer size4 = in4.size();
        Integer size0 = in0.size();
        Integer size1 = in1.size();

        // then
        assertThat(size4, equalTo(4));
        assertThat(size0, equalTo(0));
        assertThat(size1, equalTo(1));
    }

    @Test
    public void shouldAddFirst() {
        // given
        LinkedList<String> in = new LinkedList<>("aa", "bb", "cc", "dd");

        // when
        in.addFirst("First");

        // then
        assertThat(in, equalTo(new LinkedList<>("First", "aa", "bb", "cc", "dd")));
    }

    @Test
    public void shouldIterate() {
        // given
        LinkedList<Integer> llit = new LinkedList<>(1, 2, 3, 4);
        List<Integer> output = new ArrayList<>();

        // when
        for (Iterator<LinkedList.Node<Integer>> itc = llit.iterator(); itc.hasNext(); ) {
            output.add(itc.next().val());
        }

        // then
        assertThat(output, equalTo(List.of(1, 2, 3, 4)));
    }

    @Test
    public void shouldReverseIterate() {
        // given
        LinkedList<Integer> llit = new LinkedList<>(1, 2, 3, 4);
        List<Integer> output = new ArrayList<>();

        // when
        for (Iterator<LinkedList.Node<Integer>> itc = llit.reIterator(); itc.hasNext(); ) {
            output.add(itc.next().val());
        }

        // then
        assertThat(output, equalTo(List.of(4, 3, 2, 1)));
    }

    @Test
    public void shouldSet() {
        // given
        LinkedList<Integer> shouldBeUpdated = new LinkedList<>(1, 2, 3, 4);

        // when
        shouldBeUpdated.set(13, 2);

        // then
        assertThat(shouldBeUpdated, equalTo(new LinkedList<>(1, 2, 13, 4)));
        assertThat(shouldBeUpdated, Matchers.not(equalTo(new LinkedList<>(1, 2, 3, 4))));
    }

    @Test
    public void shouldGet() {
        // given
        LinkedList<Integer> ints = new LinkedList<>(2, 3, 45);

        // when
        int got = ints.get(2);

        // then
        assertThat(got, equalTo(45));
    }

    @Test
    public void shouldRemoveAt0() {
        // given
        LinkedList<Integer> ints = new LinkedList<>(3123);

        // when
        Integer out = ints.removeAt(0);

        // then
        assertThat(out, equalTo(3123));
        assertThat(ints, equalTo(new LinkedList<>()));
    }

    @Test
    public void shouldRemoveAt() {
        // given
        LinkedList<String> strings = new LinkedList<>("Super", "Router", "Trzeci", "Łączył", "Małe", "Sieci");

        // when
        String out = strings.removeAt(1);

        // then
        assertThat(out, equalTo("Router"));
        assertThat(strings, equalTo(new LinkedList<>("Super", "Trzeci", "Łączył", "Małe", "Sieci")));

        // when
        out = strings.removeAt(0);

        // then
        assertThat(out, equalTo("Super"));
        assertThat(strings, equalTo(new LinkedList<>("Trzeci", "Łączył", "Małe", "Sieci")));

        // when
        out = strings.removeAt(3);

        // then
        assertThat(out, equalTo("Sieci"));
        assertThat(strings, equalTo(new LinkedList<>("Trzeci", "Łączył", "Małe")));

        String removed = strings.removeAt(0);
        assertThat(removed, equalTo("Trzeci"));

        removed = strings.removeAt(0);
        assertThat(removed, equalTo("Łączył"));

        removed = strings.removeAt(0);
        assertThat(removed, equalTo("Małe"));
    }

    @Test
    public void shouldReturnIndexOf() {
        // given
        LinkedList<Integer> ints = new LinkedList<>(11, 22, 33, 44, 55);

        // when
        Optional<Integer> indexFound = ints.indexOf(33);
        Optional<Integer> indexNotFound = ints.indexOf(66);

        // then
        assertThat(indexFound, equalTo(Optional.of(2)));
        assertThat(indexNotFound, equalTo(Optional.empty()));
    }

    @Test
    public void shouldSwap() {
        // given
        LinkedList<Integer> ints = new LinkedList<>(11, 22, 33, 44, 55);

        // when
        ints.swap(1, 2);

        // then
        assertThat(ints, equalTo(new LinkedList(11, 33, 22, 44, 55)));

        // when
        ints.swap(0, 0);

        // then
        assertThat(ints, equalTo(new LinkedList(11, 33, 22, 44, 55)));

        // when
        ints.swap(3, 2);

        // then
        assertThat(ints, equalTo(new LinkedList(11, 33, 44, 22, 55)));

        // when
        ints.swap(3, 0);

        // then
        assertThat(ints, equalTo(new LinkedList(22, 33, 44, 11, 55)));

    }

    @Test
    public void shouldSwap2() {
        // given
        LinkedList<Integer> ints = new LinkedList<>(2, 4, 1, 3, 8, 7, 9, 6, 5);

        // when
        ints.swap(3, 8);

        // then
        assertThat(ints, equalTo(new LinkedList(2, 4, 1, 5, 8, 7, 9, 6, 3)));

    }

    @Test
    public void shouldRemove() {
        // given
        LinkedList<String> strings = new LinkedList<>("It's", "over", "Anakin");

        // when
        Optional<String> anakin = strings.remove("Anakin");

        // then
        assertThat(anakin, equalTo(Optional.of("Anakin")));
        assertThat(strings, equalTo(new LinkedList<>("It's", "over")));

        // when
        Optional<String> legs = strings.remove("legs");

        // then
        assertThat(legs, equalTo(Optional.empty()));
        assertThat(strings, equalTo(new LinkedList<>("It's", "over")));
    }
}
