package cn.shui.order;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/10/23
 * H指数
 */
public class L274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public int hIndex2(int[] citations) {
        int len = citations.length;
        int[] counter = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len) {
                counter[len]++;
            } else {
                counter[citations[i]]++;
            }
        }
        int total = 0;
        for (int i = len; i >= 0; i--) {
              total = counter[i];
              if (total >= i) {
                  return i;
              }
        }
        return 0;
    }
}
