package interview.excercise.chapter1;

import org.junit.jupiter.api.Test;

import static interview.excercise.chapter1.URLify.urlify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class URLifyTest {

    @Test
    public void shouldUrlify() {
        // given
        char[] str = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
        int trueLen = 13;

        // when
        urlify(str, trueLen);

        // then
        assertThat(str, equalTo(new char[]{'M', 'r', '%', '2', '0', 'J', 'o', 'h', 'n', '%', '2', '0', 'S', 'm', 'i', 't', 'h'}));
    }
}