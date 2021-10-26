package cn.shui.order;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/10/26.
 * @time 10:18.
 * 下一个更大元素I
 */
public class L496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0, len2 = nums2.length, count = 0;
        int[] ans = new int[nums1.length];
        for (int num : nums1) {
            if (map.containsKey(num)) {
                for (int i = map.get(num); i < len2; i++) {
                    map.put(nums2[i], i);
                    if (num < nums2[i]) {
                        ans[count++] = nums2[i];
                        break;
                    }
                    if (i == len2 - 2) {
                        ans[count++] = -1;
                    }
                }
            } else {
                while (num != nums2[index]) {
                    map.put(nums2[index], index++);
                }
                for (int i = index; i < len2; i++) {
                    map.put(nums2[i], i);
                    if (num < nums2[i]) {
                        ans[count++] = nums2[i];
                        break;
                    }
                    if (i == len2 - 1) {
                        ans[count++] = -1;
                    }
                }
            }
        }
        return ans;
    }

    // 单调栈+哈希表
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
