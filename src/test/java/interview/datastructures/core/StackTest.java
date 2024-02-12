package interview.datastructures.core;

import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    public void allInTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assert stack.peek() == 3;
        assert stack.pop() == 3;
        assert stack.pop() == 2;
        assert !stack.isEmpty();
        assert stack.pop() == 1;
        assert stack.isEmpty();
        stack.push(4);
        assert !stack.isEmpty();
        assert stack.peek() == 4;
    }

}