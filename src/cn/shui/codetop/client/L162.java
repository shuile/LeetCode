package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/21
 * 寻找峰值
 */
public class L162 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        if (len == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len -1] > nums[len - 2]) {
            return len - 1;
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // 迭代爬坡
    public int findPeakElement2(int[] nums) {
        int len = nums.length;
        int idx = (int) (Math.random() * len);
        while (!(compare(nums, idx - 1, idx) < 0 && compare(nums, idx, idx + 1) > 0)) {
            if (compare(nums, idx, idx + 1) < 0) {
                idx++;
            } else {
                idx--;
            }
        }
        return idx;
    }

    private int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);
        if (num1[0] != num2[0]) {
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }

    private int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }

    // 迭代爬坡的二分优化
    public int findPeakElement3(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                return mid;
            }
            if (compare(nums, mid, mid + 1) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int findPeakElement4(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cmpL = compare1(nums, mid - 1, mid);
            int cmpR = compare1(nums, mid, mid + 1);
            if (cmpL < 0 && cmpR > 0) {
                return mid;
            }
            if (cmpL > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int compare1(int[] nums, int idx1, int idx2) {
        if (idx1 < 0) {
            return -1;
        }
        if (idx2 >= nums.length) {
            return 1;
        }
        return nums[idx1] - nums[idx2];
    }
}
