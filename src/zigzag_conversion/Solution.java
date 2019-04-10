package zigzag_conversion;

public class Solution {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    private static String convert(String s, int numRows) {
        if (s == null || s.length() < 1) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int block = s.length() / (2 * numRows - 2);
        if ((s.length() / (2.0 * numRows - 2)) > block) {
            block++;
        }
        String ans = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < block; j++) {
                int t1 = i + j * (2 * numRows - 2);
                if (t1 >= s.length()) {
                    continue;
                }
                ans += s.charAt(t1);
                if (i == 0 || i == (numRows - 1)) {
                    continue;
                }
                int t2 = t1 + 2 * (numRows - 1 - i);
                if (t2 >= s.length()) {
                    continue;
                }
                ans += s.charAt(t2);
            }
        }
        return ans;
    }
}
