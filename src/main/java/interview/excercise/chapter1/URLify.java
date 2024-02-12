package interview.excercise.chapter1;

public class URLify {

    // assumptions from the exercise:
    // 1. in array has sufficient spaces at end
    // 2. trueLen hold's "true" length of the escaped string
    public static void urlify(char[] in, int trueLen) {
        for(int i = trueLen - 1; i > 0; i--) {
            if(in[i] == ' ') {
                moveAndEscapeAt(i, in, trueLen);
                trueLen += 2;
            }
        }
    }

    private static void moveAndEscapeAt(int index, char[] in, int trueLen) {
        for(int i = trueLen + 1; i > index; i--) {
            in[i] = in[i - 2];
        }
        in[index] = '%';
        in[index+1] = '2';
        in[index+2] = '0';
    }
}
