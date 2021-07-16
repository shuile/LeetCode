package cn.shui.learning_plan.algorithms.third_day;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/7/16.
 * @time 09:54.
 */
public class L167 {
    // 双指针
    private int[] twoSum1(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }
        int left = 0, right = numbers.length - 1, sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    private int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int len = numbers.length, diff;
        for (int i = 0; i < len; i++) {
            diff = target - numbers[i];
            map.put(diff, i + 1);
        }
        for (int i = 0; i < len; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[] {i + 1, map.get(numbers[i])};
            }
        }
        return new int[0];
    }

    private int[] twoSum3(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int len = numbers.length, diff;
        for (int i = 0; i < len; i++) {
            diff = target - numbers[i];
            if (map.containsKey(numbers[i])) {
                return new int[] {map.get(numbers[i]), i + 1};
            }
            map.put(diff, i + 1);
        }
        return new int[0];
    }

    // 二分查找
    private int[] twoSum4(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[] {-1, -1};
        }
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[] {i + 1, mid + 1};
                }
                if (numbers[mid] < target - numbers[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return new int[] {-1, -1};
    }
}
