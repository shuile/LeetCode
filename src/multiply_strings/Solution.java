package multiply_strings;

public class Solution {
    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        System.out.println(multiply(num1, num2));
    }

    private static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                result[i + j + 1] += d1 * d2;
                result[i + j] += result[i + j + 1] / 10;
                result[i + j + 1] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (sb.length() == 0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        if (sb.length() == 0) {
            sb.append(0);
        }
        return sb.toString();
    }
}
