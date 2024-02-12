package interview.excercise.chapter1;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.toLowerCase;

public class PalindromePermutation {

    public static boolean isPalindromePermutation(char[] in) {
        Map<Character, Integer> counter = new HashMap<>();
        int len = in.length;
        for(int i = 0; i < len; i++) {
            if(in[i] != ' ') {
                char key = toLowerCase(in[i]);
                counter.put(key, counter.getOrDefault(key, 0) + 1);
            }
        }
        int unevenCount = 0;
        for(char c : counter.keySet()) {
            char key = toLowerCase(c);
            if(counter.get(key) % 2 != 0) {
                unevenCount++;
            }
            if(unevenCount > 1) {
                return false;
            }
        }
        return true;
    }
}
