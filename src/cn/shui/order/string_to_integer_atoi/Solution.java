package cn.shui.order.string_to_integer_atoi;

public class Solution {
    public static void main(String[] args) {
        String s1 = "00000   ";
        System.out.println(myAtoi(s1));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    private static int myAtoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        if (str.length() == 1 && (str.charAt(0) >= '0' && str.charAt(0) <= '9')) {
            return Integer.valueOf(str);
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < str.length(); i++) {
            if (start == -1) {
                if ('+' == str.charAt(i) || '-' == str.charAt(i) || ('0' <= str.charAt(i) && '9' >= str.charAt(i))) {
                    start = i;
                    continue;
                } else if (' ' == str.charAt(i)){
                    continue;
                } else {
                    return 0;
                }
            }
            if (start != -1 && !('0' <= str.charAt(i) && '9' >= str.charAt(i))) {
                if (str.charAt(start) >= '0' && str.charAt(start) <= '9') {
                    end = i - 1;
                    break;
                } else {
                    if ((i - start) > 1) {
                        end = i - 1;
                        break;
                    } else {
                        return 0;
                    }
                }
            }
            if (start != -1 && i == str.length() - 1) {
                end = i;
            }
        }
        if (start <= -1 || end <= -1) {
            return 0;
        }
        String ansStr = str.substring(start, end + 1);
        long ansLong = 1;
        if (ansStr.charAt(0) == '+') {
            ansStr = ansStr.substring(1, ansStr.length());
        }
        if (ansStr.charAt(0) == '-') {
            ansLong *= - 1;
            ansStr = ansStr.substring(1, ansStr.length());
        }
        int i = 0;
        for ( ; i < ansStr.length(); i++) {
            if (ansStr.charAt(i) != '0') {
                break;
            }
        }
        ansStr = ansStr.substring(i, ansStr.length());
        if (ansStr.length() > 10) {
            if (ansLong == -1) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        if (ansStr.length() < 1) {
            return 0;
        }
        ansLong = ansLong * Long.valueOf(ansStr);
        if (ansLong > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (ansLong < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) ansLong;
    }
}
