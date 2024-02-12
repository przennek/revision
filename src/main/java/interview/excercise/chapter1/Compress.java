package interview.excercise.chapter1;

public class Compress {

    public static String compress(String in) {
        int count = 0;
        int pos = 0;
        StringBuilder comp = new StringBuilder();
        for(int i = 0; i < in.length(); i++) {
            if(count == 0) {
                comp.append(in.charAt(i));
                pos++;
                count++;
            }
            if(i + 1 >= in.length()) {
                comp.append(count);
                count = 0;
            } else if(in.charAt(i) == in.charAt(i + 1)) {
                count++;
            } else {
                comp.append(count);
                count = 0;
            }
        }

        return pos < in.length() ? comp.toString() : in;
    }
}
