package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/23
 */
public class L415 {
    public String addStrings(String num1, String num2) {
        if (isZero(num1)) {
            return num2;
        }
        if (isZero(num2)) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len1 = num1.length() - 1, len2 = num2.length() - 1;
        while (len1 >= 0 || len2 >= 0) {
            int a = len1 >= 0 ? num1.charAt(len1) : 0;
            int b = len2 >= 0 ? num2.charAt(len2) : 0;
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            len1--;
            len2--;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private boolean isZero(String str) {
        return "0".equals(str);
    }
}
