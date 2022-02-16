package cn.shui.order;

/**
 * @author shui.
 * @date 2022/2/16.
 * @time 21:31.
 */
public class L171 {
    public int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        long ans = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            ans += Math.pow(26, len - i - 1) * (arr[i] - 'A' + 1);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        L171 test = new L171();
        System.out.println(test.titleToNumber("AB"));
    }

    // 进制转换
    public int titleToNumber2(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }
}
