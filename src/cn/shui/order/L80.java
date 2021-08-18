package cn.shui.order;

/**
 * @author shui.
 * @date 2021/8/18.
 * @time 15:57.
 * 删除有序数组中的重复项II
 */
public class L80 {
    public int removeDuplicates1(int[] nums) {
        int preIndex = 0, realIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[preIndex]) {
                if (realIndex - preIndex < 2) {
                    nums[realIndex++] = nums[i];
                }
            } else {
                nums[realIndex] = nums[i];
                preIndex = realIndex;
                realIndex++;
            }
        }
        return realIndex;
    }

    // 双指针
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
