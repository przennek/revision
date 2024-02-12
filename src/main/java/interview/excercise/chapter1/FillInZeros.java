package interview.excercise.chapter1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FillInZeros {

    public static void fill(int[][] in, int n, int m) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(in[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    in[i][j] = 0;
                }
            }
        }

    }
}
