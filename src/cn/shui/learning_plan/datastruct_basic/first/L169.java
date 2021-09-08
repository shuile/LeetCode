package cn.shui.learning_plan.datastruct_basic.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author shui.
 * @date 2021/8/30.
 * @time 09:16.
 * 多数元素
 */
public class L169 {

    public static void main(String[] args) {
        L169 test = new L169();
        int i = test.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }

    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        Arrays.sort(nums);
        int start = 0, end = 0, len = nums.length;
        for (int i = 1; i < len; i++) {
            end = i;
            if (nums[i] == nums[i - 1]) {
                if ((end - start + 1) > len / 2) {
                    return nums[i];
                }
            } else {
                start = i;
            }
        }
        if (start == 0 && end == 0) {
            return nums[0];
        }
        return -1;
    }

    // 哈希表
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int half = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > half) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 排序
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 随机化
    public int majorityElement4(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i : nums) {
            if (i == num) {
                count++;
            }
        }
        return count;
    }

    // 分治
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority element.
        if (lo == hi) {
            return nums[lo];
        }
        // resource on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }
        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
