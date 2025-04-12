package cn.shui.order;

/**
 * Created by chenyiting on 2025/4/12
 * Convert a Number to Hexadecimal
 */
public class L405 {

    private static final char[] HEXS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        StringBuilder ans = new StringBuilder();
        boolean isNegative = num < 0;
        boolean isZero = num == 0;
        num = Math.abs(num);
        if (isNegative) {
            int carry = 0;
            int count = 0;
            for (int i = 0; i < 32; i++) {
                int remain = num % 2;
                if (i == 0) {
                    carry = (1 - remain + 1) / 2;
                    remain = (1 - remain + 1) % 2;
                } else {
                    remain = 1 - remain + carry;
                    carry = remain / 2;
                    remain = remain % 2;
                }
                count = count + (remain << (i % 4));
                if (i % 4 == 3) {
                    ans.append(HEXS[count]);
                    count = 0;
                }
                num >>= 1;
            }
        } else if (isZero) {
            ans.append(0);
        } else {
            while (num != 0) {
                ans.append(HEXS[num % 16]);
                num /= 16;
            }
        }

        if (ans.length() == 0) {
            ans.append(0);
        }
        return ans.reverse().toString();
    }

    public String toHex2(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int val = (num >> (4 * i)) & 0xf;
            if (ans.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                ans.append(digit);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        L405 test = new L405();
        System.out.println(test.toHex(-2));
    }
}
