package interview.excercise.chapter1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CompressTest {

    @Test
    public void compressTest() {
        // given
        String toBeCompressed = "aaaabbcddddddddddddt";

        // when
        String out = Compress.compress(toBeCompressed);

        // then
        assertThat(out, equalTo("a4b2c1d12t1"));
    }

    @Test
    public void compressTest2() {
        // given
        String toBeCompressed = "abcd";

        // when
        String out = Compress.compress(toBeCompressed);

        // then
        assertThat(out, equalTo("abcd"));
    }

}