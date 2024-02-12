package interview.datastructures.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    public void allInOne() {
        Queue<Integer> queue = new Queue<>();
        assert queue.isEmpty();

        queue.add(1);

        assert !queue.isEmpty();

        queue.add(2);
        queue.add(3);
        queue.add(4);

        assert !queue.isEmpty();

        assert queue.remove() == 1;
        assert queue.remove() == 2;

        assert !queue.isEmpty();

        assert queue.remove() == 3;

        assert queue.peek() == 4;

        assert queue.remove() == 4;

        assert queue.isEmpty();
    }

}