package regular_expression_matching;

public class Solution {
    public static void main(String[] args) {
        String s = "";
        String p = "a*";
        System.out.println(isMatch(s, null));
    }

    private static boolean isMatch(String s, String p) {
        if (p == null) {
            if (s == null) {
                return true;
            } else {
                return false;
            }
        }
        if (s == null) {
            return false;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
