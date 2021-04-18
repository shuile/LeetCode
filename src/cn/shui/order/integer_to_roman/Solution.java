package cn.shui.order.integer_to_roman;

public class Solution {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

    private static String intToRoman(int num) {
        int[] n = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] str = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String ans = "";
        int len = n.length - 1;
        while (num > 0) {
            int count = num / n[len];
            for (int i = 0; i < count; i++) {
                ans += str[len];
            }
            num %= n[len--];
        }
        return ans;
    }
}
