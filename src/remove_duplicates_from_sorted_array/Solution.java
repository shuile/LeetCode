package remove_duplicates_from_sorted_array;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("nums1.length=" + removeDuplicates(nums1));
        System.out.println("nums2.length=" + removeDuplicates(nums2));
    }

    //返回不重复的数组长度
    public static int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums.length <= 0) {
            return len;
        }
        int tmp = nums[0];
        len++;
        for (int i = 1; i < nums.length; i++) {
            if (tmp != nums[i]) {
                tmp = nums[i];
                nums[len] = tmp;
                len++;
            } else {
                continue;
            }
        }
        return len;
    }
}
