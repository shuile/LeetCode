package cn.shui.codetop.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenyiting on 2022/6/20
 */
public class L442 {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (set.contains(num)) {
                ans.add(num);
            } else {
                set.add(num);
            }
        }
        return ans;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int reLocate = Math.abs(nums[i]) - 1;
            if (nums[reLocate] < 0) {
                ans.add(Math.abs(nums[i]));
            } else {
                nums[reLocate] = -nums[reLocate];
            }
        }
        return ans;
    }

    public List<Integer> findDuplicates3(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
