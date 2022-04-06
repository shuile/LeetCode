package cn.shui.codetop.client;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/4/5
 * 字符串相乘
 */
public class L43 {
    public String multiply(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        int len1 = num2.length(), len2 = num2.length();
        char[] nums = new char[len1 + len2];
        int len = nums.length;
        if (len == 0) {
            return "0";
        }
        Arrays.fill(nums, '0');
        int carry = 0, index = len - 1;
        for (int i = len1 - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            if (a > 0) {
                int currentIndex = index;
                for (int j = len2 - 1; j >= 0; j--) {
                    int b = num2.charAt(j) - '0';
                    currentIndex = index - (len2 - j - 1);
                    int temp = (a * b) + carry + (nums[currentIndex] - '0');
                    carry = temp / 10;
                    nums[currentIndex] = (char) (temp % 10 + '0');
                }
                currentIndex = index - len2;
                while (carry > 0) {
                    nums[currentIndex] += carry;
                    carry = nums[currentIndex] / 10;
                    nums[currentIndex] %= 10;
                }
            }
            index--;
        }
        int startIndex = 0;
        for (; startIndex < len; startIndex++) {
            if (nums[startIndex] != '0') {
                break;
            }
        }
        if (startIndex == len) {
            return "0";
        }
        char[] ans = new char[len - startIndex];
        System.arraycopy(nums, startIndex, ans, 0, len - startIndex);
        return new String(ans);
    }

    public static void main(String[] args) {
        L43 test = new L43();
        System.out.println(test.multiply("123", "456"));
    }
}
