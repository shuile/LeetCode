package cn.shui.learning_plan.offer.thirty;

/**
 * @author shui.
 * @date 2021/11/24.
 * @time 08:56.
 * 打印从1到最大的n位数
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int len = (int) (Math.pow(10, n) - 1);
        int l = 0, r = len - 1;
        int[] ans = new int[len];
        while (l <= r) {
            ans[l] = l + 1;
            ans[r] = r + 1;
            l++;
            r--;
        }
        return ans;
    }

    private int[] res;
    private int nine = 0, count = 0, start, n;
    private char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers2(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    private void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) {
                res[count++] = Integer.parseInt(s);
                if (n - start == nine) {
                    start--;
                }
                return;
            }
            for (char i : loop) {
                if (i == '9') {
                    nine++;
                }
                num[x] = i;
                dfs(x + 1);
            }
            nine--;
        }
    }
}
