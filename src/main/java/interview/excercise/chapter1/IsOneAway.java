package interview.excercise.chapter1;

public class IsOneAway {

    public static boolean isOneAway(char[] in1, char[] in2) {
        char[] longer = null;
        char[] shorter = null;
        if(in1.length > in2.length) {
            longer = in1;
            shorter = in2;
        } else {
            longer = in2;
            shorter = in1;
        }
        int diff = 0;
        for(int l = 0, s = 0; l < longer.length; l++) {
            if(s >= shorter.length || longer[l] != shorter[s]) {
                diff++;
            } else {
                s++;
            }
        }

        boolean oneInsertOrOneDeleteAway = diff <= 1;

        if(!oneInsertOrOneDeleteAway) {
            if(in1.length != in2.length) {
                return false;
            }
            diff = 0;
            for(int i = 0; i < in1.length; i++) {
                if(in1[i] != in2[i]) {
                    diff++;
                }
            }
            return diff <= 1;
        } else {
            return true;
        }
    }
}
