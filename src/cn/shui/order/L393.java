package cn.shui.order;

/**
 * Created by chenyiting on 2025/2/24
 * UTF-8 Validation
 */
public class L393 {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length < 1) {
            return false;
        }
        int len = data.length;
        int pos = 0;
        int bits = 0;
        int tmp;
        int leftBit = 128;
        while (pos < len) {
            bits = 0;
            tmp = data[pos];
            leftBit = 128;
            while ((leftBit & tmp) == leftBit && leftBit > 0) {
                bits++;
                leftBit >>>= 1;
            }
            if (bits == 0) {
                if (tmp >= (1 << 7)) {
                    return false;
                }
                pos++;
            } else if (bits > 1 && bits <= 4) {
                for (int i = 1; i < bits; i++) {
                    if (pos + i >= len || (data[pos + i] >>> 6) != 2) {
                        return false;
                    }
                }
                pos += bits;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L393 test = new L393();
        System.out.println(test.validUtf8(new int[]{250, 145, 145, 145, 145,}));
    }
}
