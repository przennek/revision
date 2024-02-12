package interview.excercise.chapter3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SetOfStacksTest {

    @Test
    public void setStacksTest() {
        // given
        SetOfStacks<Integer> stacks = new SetOfStacks<>(1);

        // when
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);

        // then
        assertThat(stacks.pop(), equalTo(5));
        assertThat(stacks.pop(), equalTo(4));
        assertThat(stacks.popAt(0), equalTo(1));
        assertThat(stacks.pop(), equalTo(3));
        assertThat(stacks.pop(), equalTo(2));
    }

}