package cn.shui.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer_39 {
    public static void main(String[] args) {

    }

    private int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        for (int num : nums) {
            int count = 1;
            if (map.containsKey(num)) {
                count += map.get(num);
            }
            map.put(num, count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= half) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += x == num ? 1 : -1;
        }
        return x;
    }
}
