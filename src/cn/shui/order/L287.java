package cn.shui.order;

/**
 * Created by chenyiting on 2022/11/15
 * 寻找重复数
 */
public class L287 {
    // 改变数组
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n] < 0) {
                return n;
            }
            nums[n] = -nums[n];
        }
        return -1;
    }

    // 二分查找
    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int l = 1, r = len - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    // 二进制
    public int findDuplicate3(int[] nums) {
        int n = nums.length, ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }
        for (int bit = 0; bit <= bit_max; bit++) {
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && (i & (1 << bit)) != 0) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }
        return ans;
    }

    // 快慢指针
    public int findDuplicate4(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
