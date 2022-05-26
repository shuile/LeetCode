package cn.shui.codetop.client;/**
 * Created by chenyiting on 2022/5/5
 * 下一个排列
 */
public class L31 {
     public void nextPermutation(int[] nums) {
         int i = nums.length - 2;
         while (i >= 0 && nums[i] >= nums[i + 1]) {
             i--;
         }
         if (i >= 0) {
             int j = nums.length - 1;
             while (j >= 0 && nums[i] >= nums[j]) {
                 j--;
             }
             swap(nums, i, j);
         }
         reverse(nums, i + 1);
     }

     private void swap(int[] nums, int i, int j) {
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
     }

     private void reverse(int[] nums, int start) {
         int l = start, r = nums.length - 1;
         while (l < r) {
             swap(nums, l, r);
             l++;
             r--;
         }
     }
}
