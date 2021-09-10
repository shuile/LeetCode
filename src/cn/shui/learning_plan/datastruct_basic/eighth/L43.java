package cn.shui.learning_plan.datastruct_basic.eighth;

/**
 * @author shui.
 * @date 2021/9/10.
 * @time 11:45.
 */
public class L43 {

    public static void main(String[] args) {
        L43 test = new L43();
        System.out.println(test.multiply1("123", "456"));
    }

    public String multiply1(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len2 < len1) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
            int t = len1;
            len1 = len2;
            len2 = t;
        }
        String ans = "0";
        for (int i = len1 - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            if (a == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for (int j = 0; j < (len1 - 1 -i); j++) {
                sb.append(0);
            }
            for (int j = len2 - 1; j >= 0; j--) {
                int sum = (num2.charAt(j) - '0') * a + carry;
                carry = sum / 10;
                sb.append(sum % 10);
            }
            if (carry > 0) {
                sb.append(carry);
            }
            ans = getSum(sb.reverse().toString(), ans);
        }
        return ans;
    }

    private String getSum(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int len1 = s1.length() - 1, len2 = s2.length() - 1, carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int a = len1 >= 0 ? s1.charAt(len1) - '0' : 0;
            int b = len2 >= 0 ? s2.charAt(len2) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            len1--;
            len2--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    // 做加法
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder curr = new StringBuilder();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    private String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result =x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return ans.reverse().toString();
    }

    // 做乘法
    public String multiply3(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}
