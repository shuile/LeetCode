package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/27.
 * @time 23:21.
 * 排序数组中只出现一次的数字
 */
public class Offer070 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, ans = 0;
        while (l <= r) {
            ans ^= nums[l];
            if (l != r) {
                ans ^= nums[r];
            }
            l++;
            r--;
        }
        return ans;
    }

    // 二分查找
    public int singleNonDuplicate2(int[] nums) {
        int l = 0, r = nums.length / 2 - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int i = 2 * mid;
            if (nums[i] != nums[i + 1]) {
                if (i == 0 || nums[i - 1] == nums[i - 2]) {
                    return nums[i];
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[nums.length - 1];
    }
}
