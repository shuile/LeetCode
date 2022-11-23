package cn.shui.order;

/**
 * @author shui.
 * @date 2022/1/10.
 * @time 11:00.
 * 累加数
 */
public class L306 {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        int len = num.length();
        for (int secondStart = 1; secondStart < len - 1; secondStart++) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < len - 1; secondEnd++) {
                if (num.charAt(secondStart) == '0' && secondEnd != secondStart) {
                    break;
                }
                if (valid(secondStart, secondEnd, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean valid(int secondStart, int secondEnd, String num) {
        int len = num.length();
        int firstStart = 0, firstEnd = secondStart - 1;
        while (secondEnd <= len - 1) {
            String third = stringAdd(firstStart, firstEnd, secondStart, secondEnd, num);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= len || !third.equals(num.substring(thirdStart, thirdEnd + 1))) {
                break;
            }
            if (thirdEnd == len - 1) {
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    private String stringAdd(int firstStart, int firstEnd, int secondStart, int secondEnd, String num) {
        StringBuilder third = new StringBuilder();
        int carry = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            if (firstEnd >= firstStart) {
                carry += num.charAt(firstEnd) - '0';
                firstEnd--;
            }
            if (secondEnd >= secondStart) {
                carry += num.charAt(secondEnd) - '0';
                secondEnd--;
            }
            third.append((char) (carry % 10 + '0'));
            carry /= 10;
        }
        return third.reverse().toString();
    }
}
