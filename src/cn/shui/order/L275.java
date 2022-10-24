package cn.shui.order;

/**
 * Created by chenyiting on 2022/10/24
 * H指数II
 */
public class L275 {
    public int hIndex(int[] citations) {
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
            total += counter[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex3(int[] citations) {
        int len = citations.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] > len - mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return len - l;
    }
}
