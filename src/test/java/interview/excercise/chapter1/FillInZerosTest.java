package interview.excercise.chapter1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class FillInZerosTest {

    @Test
    public void shouldFillInZeros() {
        // given
        int[][] matrix = new int[][] {
                {1, 0, 3, 4, 5},
                {1, 1, 0, 4, 5},
                {1, 1, 3, 0, 5},
                {1, 2, 3, 4, 5},
        };

        // when
        FillInZeros.fill(matrix, 4, 5);

        // then
        assertThat(matrix, equalTo(new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 5}
        }));
    }
}