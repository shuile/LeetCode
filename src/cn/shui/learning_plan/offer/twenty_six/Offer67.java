package cn.shui.learning_plan.offer.twenty_six;

/**
 * @author shui.
 * @date 2021/11/20.
 * @time 16:22.
 * 把字符串转换成整数
 */
public class Offer67 {

    public static void main(String[] args) {
        Offer67 test = new Offer67();
        test.strToInt("20000000000000000000");
    }

    public int strToInt(String str) {
        if (str == null) {
            return 0;
        }
        int len = str.length();
        int index = 0;
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index >= len || (str.charAt(index) != '+' && str.charAt(index) != '-' && (str.charAt(index) < '0' || str.charAt(index) > '9'))) {
            return 0;
        }
        boolean isPositive = true;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            isPositive = str.charAt(index) == '+';
            index++;
        }
        int start = index;
        while (index < len && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            index++;
        }
        if (start == index) {
            return 0;
        }
        String valueStr = str.substring(start, index);
        start = 0;
        while (start < valueStr.length() && valueStr.charAt(start) == '0') {
            start++;
        }
        valueStr = valueStr.substring(start);
        if (valueStr.length() < 1) {
            return 0;
        }
        if (valueStr.length() > 10) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            long value = Long.parseLong(valueStr);
            value = isPositive ? value : -value;
            if (value > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (value < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) value;
        }
    }

    // 优化
    public int strToInt2(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+'){
            i = 0;
        }
        for (int j = i; i < c.length; j++) {
            if (c[j] <'0' || c[j] >'9') {
                break;
            }
            if (res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

    // 优化
    public int strToInt3(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, len = str.length();
        if (len == 0) {
            return 0;
        }
        while (str.charAt(i) == ' ') {
            if (++i == len) {
                return 0;
            }
        }
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            i++;
        }
        for (int j = i; j < len; j++) {
            if (str.charAt(j) < '0' || str.charAt(j) >'9') {
                break;
            }
            if (res > bndry || res == bndry && str.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }
}
