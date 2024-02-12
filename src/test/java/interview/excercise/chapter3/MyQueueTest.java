package interview.excercise.chapter3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MyQueueTest {

    @Test
    public void queueTest() {
        // given
        MyQueue<Integer> queue = new MyQueue<>();

        // when
        queue.push(1);
        queue.push(2);
        queue.push(3);

        // then
        assertThat(queue.remove(), equalTo(1));
        assertThat(queue.remove(), equalTo(2));
        queue.push(5);
        queue.push(6);
        assertThat(queue.remove(), equalTo(3));
        assertThat(queue.remove(), equalTo(5));
        assertThat(queue.remove(), equalTo(6));
    }

}