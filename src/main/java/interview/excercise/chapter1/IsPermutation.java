package interview.excercise.chapter1;

import java.util.HashMap;
import java.util.Map;

public class IsPermutation {

    public static boolean isPermutation(String first, String second) {
        Map<Character, Integer> counter = new HashMap<>();
        for(char c : first.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for(char c : second.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) - 1);
        }
        for(char c : counter.keySet()) {
            if(counter.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

}
