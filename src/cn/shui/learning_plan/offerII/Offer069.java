package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/27.
 * @time 23:10.
 * 山峰数组的顶部
 */
public class Offer069 {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (arr[i] > arr[i + 1]) {
                    return 0;
                }
            } else if (i == len - 1) {
                if (arr[i] > arr[i - 1]) {
                    return len - 1;
                }
            } else {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 二分查找
    public int peakIndexMountainArray2(int[] arr) {
        int len = arr.length;
        int l = 1, r = len - 2, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
