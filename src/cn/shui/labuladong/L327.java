package cn.shui.labuladong;

/**
 * Created by chenyiting on 2022/6/7
 * 区间的个数
 */
public class L327 {

    // 超时
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        long[] preSum = new long[len + 1];
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                long diff = preSum[i] - preSum[j];
                if (diff >= lower && diff <= upper) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int lower, upper, ans = 0;
    private long[] temp;

    // 归并排序
    public int countRangeSum2(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        long[] preSum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        sort(preSum);
        return ans;
    }

    private void sort(long[] nums) {
        temp = new long[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(long[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(long[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        int start = mid + 1, end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            while (start <= hi && nums[start] - nums[i] < lower) {
                start++;
            }
            while (end <= hi && nums[end] - nums[i] <= upper) {
                end++;
            }
            ans += end - start;
        }
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else {
                nums[p] = temp[i] > temp[j] ? temp[j++] : temp[i++];
            }
        }
    }
}
