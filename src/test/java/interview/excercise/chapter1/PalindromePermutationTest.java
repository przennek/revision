package interview.excercise.chapter1;

import org.junit.jupiter.api.Test;

import static interview.excercise.chapter1.PalindromePermutation.isPalindromePermutation;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PalindromePermutationTest {

    @Test
    public void isPalindromePermutationTest() {
        // given
        String permutation = "Taco Cat";
        String nonPermutation = "taco dog";

        // when
        boolean shouldBeTrue = isPalindromePermutation(permutation.toCharArray());
        boolean shouldBeFalse = isPalindromePermutation(nonPermutation.toCharArray());

        // then
        assertThat(shouldBeTrue, equalTo(true));
        assertThat(shouldBeFalse, equalTo(false));
    }

}