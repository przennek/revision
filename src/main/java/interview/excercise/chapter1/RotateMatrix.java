package interview.excercise.chapter1;

public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n - 1; i++) {
            Integer ini = null;
            Integer r = null;
            Integer c = null;
            for(int j = 0; j < n; j++) {
                if(ini == null) {
                    ini = matrix[i][j];
                    r = i;
                    c = j;
                }

                matrix[r][c] = matrix[n - c - 1][r];

                int cCopy = c;

                c = r;
                r = n - cCopy - 1;
            }
            matrix[r][c] = ini;
        }
    }
}
