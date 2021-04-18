package cn.shui.order.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "23";
        List<String> ans = letterCombinations(s);
        for (String s1 : ans) {
            System.out.print(s1 + "  ");
        }
        System.out.println();
    }

    private static List<String> letterCombinations(String digits) {
        List<String> ansList = new ArrayList<>();
        if (digits == null || digits.length() < 1) {
            return ansList;
        }
        String[][] str = {{"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}};
        int len = digits.length();
        int[] digit = new int[len];
        int[] carry = new int[len];
        for (int i = 0; i < len; i++) {
            digit[i] = Integer.valueOf("" + digits.charAt(i)) - 2;
            carry[i] = 0;
        }
        int totalSumNum = 1;
        for (int i = 0; i < len; i++) {
            totalSumNum *= str[digit[i]].length;
        }
        for (int i = 0; i < totalSumNum; i++) {
            String ans = "";
            for (int j = 0; j < len; j++) {
                ans = ans.concat(str[digit[j]][carry[j]]);
            }
            carry[len - 1]++;
            for (int k = len -1; k > 0; k--) {
                if (carry[k] >= str[digit[k]].length) {
                    carry[k] = 0;
                    carry[k - 1]++;
                }
            }
            ansList.add(ans);
        }
        return ansList;
    }
}
