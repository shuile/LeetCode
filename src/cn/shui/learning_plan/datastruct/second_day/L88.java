package cn.shui.learning_plan.datastruct.second_day;

import java.util.Arrays;

/**
 * @author shui.
 * @date 2021/8/17.
 * @time 09:30.
 * 合并两个有序数组
 */
public class L88 {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int min = Integer.MIN_VALUE;
        while (m > 0 || n > 0) {
            int t1 = m > 0 ? nums1[m - 1] : min;
            int t2 = n > 0 ? nums2[n - 1] : min;
            if (t1 > t2) {
                m--;
                nums1[m + n] = t1;
            } else {
                n--;
                nums1[m + n] = t2;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int min = Integer.MIN_VALUE;
        while (m > 0 && n > 0) {
            int t1 = nums1[m - 1];
            int t2 = nums2[n - 1];
            if (t1 > t2) {
                m--;
                nums1[m + n] = t1;
            } else {
                n--;
                nums1[m + n] = t2;
            }
        }
        while (n > 0) {
            n--;
            nums1[n] = nums2[n];
        }
    }

    // 直接合并后排序
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    // 双指针
    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }

    // 逆向双指针
    public void merge5(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
