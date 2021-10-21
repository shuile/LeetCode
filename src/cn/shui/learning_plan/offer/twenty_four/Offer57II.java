package cn.shui.learning_plan.offer.twenty_four;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/10/21.
 * @time 10:46.
 */
public class Offer57II {
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[0][0];
        }
        List<int[]> list = new ArrayList<>();
        int start = target / 2 + 1;
        // for (int i = 1; i < start; i++) {
        //     int sum = i;
        //     int j = i + 1;
        //     for (; j<= start; j++) {
        //         sum += j;
        //         if (sum >= target) {
        //             break;
        //         }
        //     }
        //     if (sum == target) {
        //         int[] arr = new int[j - i + 1];
        //         for (int k = 0; k < arr.length; k++) {
        //             arr[k] = k + i;
        //         }
        //         list.add(arr);
        //     }
        // }
        // int[][] ans = new int[list.size()][];
        // for (int i = 0; i < list.size(); i++) {
        //     ans[i] = list.get(i);
        // }
        for (int i = start; i >= 2; i--) {
            int sum = i;
            int j = i - 1;
            for (; j >= 1; j--) {
                sum += j;
                if (sum >= target) {
                    break;
                }
            }
            if (sum == target) {
                int[] arr = new int[i - j + 1];
                for (int k = 0; k < arr.length; k++) {
                    arr[k] = j + k;
                }
                list.add(arr);
            }
        }
        int size = list.size();
        int[][] ans = new int[size][];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(size - i - 1);
        }
        return ans;
    }

    // 求和公式
    public int[][] findContinuousSequence2(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            j = (- 1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if (i < j && j == (int)(j)) {
                int[] ans = new int[(int) j - i + 1];
                for (int k = i; k <= (int) j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }

    // 滑动窗口(双指针)
    public int[][] findContinuousSequence3(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
