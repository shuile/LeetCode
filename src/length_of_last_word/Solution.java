package length_of_last_word;

public class Solution {

    public static void main(String[] args) {
        String str = "b a  ";
        System.out.println(lengthOfLastWord(str));
    }

    //
    public static int lengthOfLastWord(String s) {
        int len = 0;
        if (s == null || s.equals("")) {
            return len;
        }
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                if (i == s.length() - 1) {
                    break;
                } else if (s.charAt(i + 1) != ' '){
                    len = 0;
                    continue;
                } else {
                    continue;
                }
            }
            len++;
        }
        return len;
    }
}
