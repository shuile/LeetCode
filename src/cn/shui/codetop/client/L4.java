package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/28
 * 寻找两个正序数组的中位数
 */
public class L4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 == 0 && len2 == 0) {
            return 0;
        }
        if (len1 == 0) {
            return len2 % 2 == 0 ? (nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2.0f : nums2[len2 / 2];
        }
        if (len2 == 0) {
            return len1 % 2 == 0 ? (nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2.0f : nums1[len1 / 2];
        }
        int l1 = 0, r1 = len1 - 1, l2 = 0, r2 = len2 - 1;
        while (l1 <= r1 || l2 <= r2) {
            if (l1 > r2) {
                if (l2 == r2) {
                    return nums2[l2];
                }
                if (r2 - l2 == 1) {
                    return (nums2[l2] + nums2[r2]) / 2.0f;
                }
                l2++;
                r2--;
            }
            if (l2 > r2) {
                if (l1 == r1) {
                    return nums1[l1];
                }
                if (r1 - l1 == 1) {
                    return (nums1[l1] + nums1[r1]) / 2.0f;
                }
                l1++;
                r1--;
            }
            if (l1 == r1 && l2 == r2) {
                return (nums1[l1] + nums2[l2]) / 2.0f;
            }
            if (nums1[l1] < nums2[l2]) {
                l1++;
            } else {
                l2++;
            }
            if (nums1[r1] > nums2[r2]) {
                r1--;
            } else {
                r2--;
            }
        }
        return 0;
    }
}
