package cn.shui.codetop.client;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 数组中第k大的元素
 */
public class L215 {

    // 冒泡排序
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        return len >= k ? nums[len - k] : nums[0];
    }

    // 堆排序
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() == k) {
                if (queue.peek() < num) {
                    queue.poll();
                    queue.offer(num);
                }
            } else {
                queue.offer(num);
            }
        }
        return queue.peek();
    }

    private Random random = new Random();

    // 快排
    public int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] a, int l , int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    private int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    private int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] < x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
