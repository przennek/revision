package interview.excercise.chapter1;

import org.junit.jupiter.api.Test;

import static interview.excercise.chapter1.IsPermutation.isPermutation;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class IsPermutationTest {

    @Test
    public void isPermutationTest() {
        // given
        String basePermutation = "aabbccddD"; // 2a2b2c2d1D
        String shouldBePermutation = "abcabcddD";
        String shouldNotBePermutation = "Bike";

        // when
        boolean shouldBeTrue = isPermutation(basePermutation, shouldBePermutation);
        boolean shouldBeFalse = isPermutation(basePermutation, shouldNotBePermutation);

        // then
        assertThat(shouldBeTrue, equalTo(true));
        assertThat(shouldBeFalse, equalTo(false));
    }

}