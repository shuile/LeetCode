package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/23
 */
public class L415 {
    // 十进制
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

    // 三十六进制
    public String add36Strings(String num1, String num2) {
        if (isZero(num1)) {
            return num2;
        }
        if (isZero(num2)) {
            return num1;
        }
        int carry = 0, x, y, temp;
        int len1 = num2.length() - 1, len2 = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || carry > 0) {
            x = len1 >= 0 ? getInt(num1.charAt(len1)) : 0;
            y = len2 >= 0 ? getInt(num2.charAt(len2)) : 0;
            temp = x + y + carry;
            carry = temp / 36;
            ans.append(getChar(temp % 36));
            len1--;
            len2--;
        }
        return ans.reverse().toString().trim();
    }

    private int getInt(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else {
            return ch - 'a';
        }
    }

    private char getChar(int x) {
        if (x >= 0 && x <= 9) {
            return (char) (x + '0');
        } else {
            return (char) (x - 10 + 'a');
        }
    }
}
