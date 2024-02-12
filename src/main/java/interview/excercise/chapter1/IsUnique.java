package interview.excercise.chapter1;

import interview.algo.QSort;

import java.util.Arrays;

// 1.1
public class IsUnique {

    public static boolean isUnique(String in) {
        char[] input = in.toCharArray();
        Arrays.sort(input);
        for(int i = 0; i < in.length() - 1; i++) {
            if(input[i] == input[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
