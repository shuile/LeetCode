package cn.shui.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer_03 {
    public static void main(String[] args) {

    }

    private static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
