package cn.shui.learning_plan.offer.fifth;

/**
 * @author shui.
 * @date 2021/9/29.
 * @time 09:41.
 * 旋转数组的最小数字
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return -1;
        }
        int len = numbers.length;
        if (numbers[0] < numbers[len - 1]) {
            return numbers[0];
        }
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] > numbers[0]) {
                l = mid + 1;
            } else if (numbers[mid] == numbers[0]) {
                if (numbers[mid] < numbers[r]) {
                    r = mid;
                } else if (numbers[mid] == numbers[r]) {
                    r--;
                } else {
                    l++;
                }
            } else {
                r = mid;
            }
        }
        return numbers[r];
    }

    // 二分查找
    public int minArray2(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}
