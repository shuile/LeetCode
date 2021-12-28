package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/28.
 * @time 11:51.
 * 数组相对排序
 */
public class Offer075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int start = 0;
        for (int k : arr2) {
            for (int j = start; j < arr1.length; j++) {
                if (arr1[j] == k) {
                    int temp = arr1[j];
                    arr1[j] = arr1[start];
                    arr1[start] = temp;
                }
            }
        }
        if (start < arr1.length) {
            for (int i = start; i < arr1.length; i++) {
                for (int j = i + 1; j < arr1.length; j++) {
                    if (arr1[i] > arr1[j]) {
                        int temp = arr1[j];
                        arr1[j] = arr1[i];
                        arr1[i] = temp;
                    }
                }
            }
        }
        return arr1;
    }

    // 计数排序
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            frequency[x]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; i++) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; x++) {
            for (int i = 0; i < frequency[x]; i++) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}
