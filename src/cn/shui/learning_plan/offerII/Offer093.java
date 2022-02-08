package cn.shui.learning_plan.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2022/1/4.
 * @time 15:28.
 * 最长裴波那契数列
 */
public class Offer093 {
    // 动态规划 + 哈希表
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }
        int ret = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i] - arr[j];
                if (map.containsKey(temp) && map.get(temp) < j) { // 存在 k 使得A[i] = A[j] + A[k] (0 <= k < j < i)
                    dp[i][j] = dp[j][map.get(temp)] + 1;
                } else { // 不存在 k 使得A[i] = A[j] + A[k] (0 <= k < j < i)
                    dp[i][j] = 2;
                }
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret > 2 ? ret : 0;
    }

    // 动态规划 + 二分查找
    public int lenLongestFibSubseq2(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        int ret = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int index = search(arr, j - 1, arr[i] - arr[j]);
                dp[i][j] = (index != -1) ? dp[j][index] + 1 : 2;
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret > 2? ret : 0;
    }

    private int search(int[] arr, int right, int target) {
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
