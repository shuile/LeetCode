package cn.shui.learning_plan.offerII;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shui.
 * @date 2021/12/29.
 * @time 10:28.
 * 数组中的第k大的数字
 */
public class Offer076 {

    public static void main(String[] args) {
        Offer076 test = new Offer076();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(test.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.add(nums[i]);
            } else {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    // 快排
    public int findKthLargest2(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int i = partition(nums, start, end);
        while (i != k - 1) {
            if (i < k - 1) {
                start = i + 1;
            } else {
                end = i - 1;
            }
            i = partition(nums, start, end);
        }
        return nums[k - 1];
    }

    private int partition(int[] nums, int start, int end) {
        int random = (int) (Math.random() * (end - start + 1) + start);
        swap(nums, random, end);
        int big = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[end]) {
                big++;
                swap(nums, big, i);
            }
        }
        big++;
        swap(nums, big, end);
        return big;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
