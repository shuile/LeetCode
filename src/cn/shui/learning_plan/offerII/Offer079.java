package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/29.
 * @time 14:13.
 * 所有子集
 */
public class Offer079 {

    public static void main(String[] args) {
        Offer079 test = new Offer079();
        int[] nums = {1, 2, 3};
        test.subsets(nums);
    }

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        if (nums == null || nums.length < 1) {
            return ans;
        }
        help(new ArrayList<>(), nums, 0);
        return ans;
    }

    private void help(List<Integer> list, int[] nums, int startIndex) {
        if (startIndex >= nums.length) {
            return;
        }
        list.add(nums[startIndex]);
        ans.add(new ArrayList<>(list));
        help(list, nums, startIndex   + 1);
        list.remove(list.size() - 1);
        help(list, nums, startIndex + 1);
    }
}
