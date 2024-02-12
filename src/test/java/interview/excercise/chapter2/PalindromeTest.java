package interview.excercise.chapter2;

import interview.excercise.chapter2.datastructures.Node;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    public void isPalindromeTest1() {
        // given
        Node<Integer> head = Node.createAndLink(
                Node.of(1),
                Node.of(2),
                Node.of(3),
                Node.of(3),
                Node.of(2),
                Node.of(1)
        );

        // when
        boolean shouldBeTrue = Palindrome.isPalindrome(head);

        // then
        assertThat(shouldBeTrue, equalTo(true));
    }

    @Test
    public void isPalindromeTest2() {
        // given
        Node<Integer> head = Node.createAndLink(
                Node.of(1),
                Node.of(2),
                Node.of(3),
                Node.of(2),
                Node.of(1)
        );

        // when
        boolean shouldBeTrue = Palindrome.isPalindrome(head);

        // then
        assertThat(shouldBeTrue, equalTo(true));
    }

    @Test
    public void isPalindromeTest3() {
        // given
        Node<Integer> head = Node.createAndLink(
                Node.of(1),
                Node.of(2),
                Node.of(3),
                Node.of(4),
                Node.of(5)
        );

        // when
        boolean shouldBeFalse = Palindrome.isPalindrome(head);

        // then
        assertThat(shouldBeFalse, equalTo(false));
    }
}