package cn.shui.learning_plan.offer.thirty;

/**
 * @author shui.
 * @date 2021/11/24.
 * @time 10:05.
 * 数组中的逆序对
 */
public class Offer51 {
    // 超时
    public int reversePairs(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                ans += nums[i] > nums[j] ? 1 : 0;
            }
        }
        return ans;
    }

    // 归并排序，分而治之
    private int[] nums, tmp;

    public int reversePairs2(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) {
            return 0;
        }
        int m = l + (r - l) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = tmp[j++];
            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                res += m - i + 1;
            }
        }
        return res;
    }
}
