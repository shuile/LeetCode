package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/2.
 * @time 19:26.
 * 排序数组中两个数字之和
 */
public class Offer006 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l, r};
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[0];
    }
}
