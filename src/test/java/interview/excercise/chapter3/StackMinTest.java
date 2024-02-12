package interview.excercise.chapter3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class StackMinTest {

    @Test
    public void shouldReturnMin() {
        StackMin<Integer> stack = new StackMin<>();

        stack.push(10);
        assertThat(stack.min(), equalTo(10));

        stack.push(5);
        assertThat(stack.min(), equalTo(5));

        stack.push(6);
        assertThat(stack.min(), equalTo(5));

        stack.push(1);
        assertThat(stack.min(), equalTo(1));

        assertThat(stack.pop(), equalTo(1));
        assertThat(stack.min(), equalTo(5));

        assertThat(stack.pop(), equalTo(6));
        assertThat(stack.min(), equalTo(5));

        assertThat(stack.pop(), equalTo(5));
        assertThat(stack.min(), equalTo(10));

        assertThat(stack.pop(), equalTo(10));
    }

}