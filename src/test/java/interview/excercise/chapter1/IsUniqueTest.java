package interview.excercise.chapter1;

import org.junit.jupiter.api.Test;

import static interview.excercise.chapter1.IsUnique.isUnique;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class IsUniqueTest {

    @Test
    public void positive() {
        // given
        String p1 = "xyzabcdefghij";
        String p2 = "321908";

        // when
        boolean p1a = isUnique(p1);
        boolean p2a = isUnique(p2);

        // then
        assertThat(p1a, equalTo(true));
        assertThat(p2a, equalTo(true));
    }

    @Test
    public void negative() {
        // given
        String p1 = "xyzabcxdefghij";
        String p2 = "3218908";

        // when
        boolean p1a = isUnique(p1);
        boolean p2a = isUnique(p2);

        // then
        assertThat(p1a, equalTo(false));
        assertThat(p2a, equalTo(false));
    }
}