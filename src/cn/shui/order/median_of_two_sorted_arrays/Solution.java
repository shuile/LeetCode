package cn.shui.order.median_of_two_sorted_arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }
        if (nums1 == null || nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        if (nums2 == null || nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
            } else {
                return nums1[nums1.length / 2];
            }
        }
        int[] nums3 = new int[nums1.length + nums2.length];
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < nums3.length; i++) {
            if (c1 >= nums1.length) {
                nums3[i] = nums2[c2++];
                continue;
            }
            if (c2 >= nums2.length) {
                nums3[i] = nums1[c1++];
                continue;
            }
            nums3[i] = (nums1[c1] < nums2[c2]) ? nums1[c1++] : nums2[c2++];
        }
        if (nums3.length % 2 == 0) {
            return (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2.0;
        } else {
            return nums3[nums3.length / 2];
        }
    }
}
