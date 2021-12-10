package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/2.
 * @time 16:14.
 * 二进制加法
 */
public class Offer002 {

    public static void main(String[] args) {
        Offer002 test = new Offer002();
        test.addBinary("1", "111");
    }

    public String addBinary(String a, String b) {
        if ("0".equals(a)) {
            return b;
        }
        if ("0".equals(b)) {
            return a;
        }
        int lenA = a.length() - 1, lenB = b.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();
        while (lenA >= 0 || lenB >= 0) {
            int chA = lenA >= 0 ? a.charAt(lenA--) - '0' : 0;
            int chB = lenB >= 0 ? b.charAt(lenB--) - '0' : 0;
            int curr = chA + chB + carry;
            carry = curr / 2;
            ans.append(curr % 2);
        }
        if (carry == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }
}
