package cn.shui.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer_56I {
    public static void main(String[] args) {

    }

    private int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        if (set.size() != 2) {
            return ans;
        }
        Integer[] integers = new Integer[2];
        set.toArray(integers);
        ans[0] = integers[0];
        ans[1] = integers[1];
        return ans;
    }

    private int[] singleNumbers2(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
