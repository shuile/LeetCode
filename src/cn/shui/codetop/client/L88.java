package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/24
 */
public class L88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[--index] = nums1[--m];
            } else {
                nums1[--index] = nums2[--n];
            }
        }
    }
}
