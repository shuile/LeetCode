package cn.shui.offer;

import java.util.Arrays;

public class Offer_40 {
    public static void main(String[] args) {

    }

    private int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k >= arr.length) {
            return arr;
        }
        Arrays.sort(arr);
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }
}
