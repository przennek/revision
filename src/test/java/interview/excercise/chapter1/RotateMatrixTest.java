package interview.excercise.chapter1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    @Test
    public void shouldRotate() {
        // given
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // when
        RotateMatrix.rotate(matrix);

        // then
        assertThat(matrix, equalTo(new int[][] {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        }));
    }

}