package cn.shui.order;

/**
 * Created by chenyiting on 2023/7/18
 */
public class L605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = -1;
        int len = flowerbed.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                if (count >= n) {
                    return true;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (len + 1) / 2;
        } else {
            count += (len - prev - 1) / 2;
        }
        return count >= n;
    }
}
