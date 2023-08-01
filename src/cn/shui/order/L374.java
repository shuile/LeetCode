package cn.shui.order;

/**
 * Created by chenyiting on 2023/8/1
 * 猜数字大小
 */
public class L374 {
    public int guessNumber(int n) {
        int l = 1, r = n;
        int ans = l + (r - l) / 2;
        while (guess(ans) != 0) {
            if (guess(ans) > 0) {
                l = ans + 1;
            } else {
                r = ans - 1;
            }
            ans = l + (r - l) / 2;
        }
        return ans;
    }

    /**
     * 优化 调用一次系统方法
     */
    public int guessNumber2(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int flag = guess(mid);
            if (flag < 0) {
                r = mid - 1;
            } else if (flag > 0) {
                l = mid + 1;
            } else {
                l = mid;
                break;
            }
        }
        return l;
    }

    /**
     * 该方法模拟系统实现
     * @param num
     * @return
     */
    private int guess(int num) {
        return 0;
    }
}
