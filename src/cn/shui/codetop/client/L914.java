package cn.shui.codetop.client;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by chenyiting on 2022/3/22
 * 数组排序
 */
public class L914 {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    // 冒泡排序-超时
    public int[] sortArray2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return nums;
    }

    // 快速排序
    public int[] sortArray3(int[] nums) {
        randomizedQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void randomizedQuickSort(int[] a, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(a, l, r);
            randomizedQuickSort(a, l, pos - 1);
            randomizedQuickSort(a, pos + 1, r);
        }
    }

    private int randomizedPartition(int[] a, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    private int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
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
