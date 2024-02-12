package interview.excercise.chapter1;

import org.junit.jupiter.api.Test;

import static interview.excercise.chapter1.IsOneAway.isOneAway;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class IsOneAwayTest {

    @Test
    public void voidIsOneAwayTest() {
        assertThat(isOneAway("pale".toCharArray(), "ple".toCharArray()), equalTo(true));
        assertThat(isOneAway("pales".toCharArray(), "pale".toCharArray()), equalTo(true));
        assertThat(isOneAway("pale".toCharArray(), "bale".toCharArray()), equalTo(true));
        assertThat(isOneAway("pale".toCharArray(), "bake".toCharArray()), equalTo(false));
    }

}