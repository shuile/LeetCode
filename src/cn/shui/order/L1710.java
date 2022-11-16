package cn.shui.order;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chenyiting on 2022/11/15
 * 卡车上的最大单元数
 */
public class L1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparing(arr -> arr[1]));
        int len = boxTypes.length;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (boxTypes[i][0] <= truckSize) {
                truckSize -= boxTypes[i][0];
                ans += boxTypes[i][0] * boxTypes[i][1];
            } else {
                ans += truckSize * boxTypes[i][1];
                break;
            }
        }
        return ans;
    }
}
