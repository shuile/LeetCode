package remove_element;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        int n1 = 3;
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int n2 = 2;
        System.out.println("nums1.length=" + removeElement(nums1, n1));
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        System.out.println("nums2.length=" + removeElement(nums2, n2));
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
    }

    //去除数组中的指定元素，并返回长度及数组
    public static int removeElement(int[] nums, int val) {
        int len = 0;
        if (nums.length <= 0) {
            return len;
        }
        int tmp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                continue;
            } else {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
