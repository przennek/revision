package interview.excercise.chapter3;

import interview.datastructures.core.Stack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class StackSortTest {
    @Test
    public void shouldSortBetter() {
        // given
        Stack<Integer> a = new Stack<>();
        a.push(4);
        a.push(2);
        a.push(1);
        a.push(1);
        a.push(5);
        a.push(7);
        a.push(9);

        // when
        a = StackSort.betterSort(a);

        // then
        List<Integer> out = new ArrayList();
        a.forEach(out::add);
        assertThat(out, equalTo(List.of(9, 7, 5, 4, 2, 1, 1)));
    }

    @Test
    public void shouldSort() {
        // given
        Stack<Integer> a = new Stack<>();
        a.push(Integer.valueOf(4));
        a.push(Integer.valueOf(2));
        a.push(Integer.valueOf(1));
//        a.push(Integer.valueOf(1));       fails :(
        a.push(Integer.valueOf(5));
        a.push(Integer.valueOf(7));
        a.push(Integer.valueOf(9));

        // when
        StackSort.sort(a);

        // then
        List<Integer> out = new ArrayList();
        a.forEach(out::add);
        assertThat(out, equalTo(List.of(9, 7, 5, 4, 2, 1)));
    }
}