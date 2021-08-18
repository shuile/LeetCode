package cn.shui.learning_plan.datastruct.third_day;

import java.util.*;

/**
 * @author shui.
 * @date 2021/8/18.
 * @time 09:29.
 * 两个数组的交集II
 */
public class L350 {

    public static void main(String[] args) {
        int[] nums1 = {0,5,8,7,2,9,7,5};
        int[] nums2 = {1,4,8,9};
        int[] intersect = intersect1(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int p = 0, q = 0;
        List<Integer> list = new ArrayList<>();
        while (p < len1 && q < len2) {
            if (nums1[p] == nums2[q]) {
                list.add(nums1[p]);
                p++;
                q++;
                continue;
            }
            if (nums1[p] > nums2[q]) {
                q++;
            } else {
                p++;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    // 哈希表
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect2(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    // 排序+双指针
    public int[] intersect3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] intersection = new int[Math.min(len1, len2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
