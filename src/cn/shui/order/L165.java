package cn.shui.order;

import java.util.Objects;

/**
 * @author shui.
 * @date 2021/11/24.
 * @time 11:18.
 * 比较版本号
 */
public class L165 {

    public static void main(String[] args) {
        L165 test = new L165();
        test.compareVersion("0.1", "1.1");
    }

    public int compareVersion(String version1, String version2) {
        if (Objects.equals(version1, version2)) {
            return 0;
        }
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len = Math.min(split1.length, split2.length);
        for (int i = 0; i < len; i++) {
            int a = Integer.parseInt(split1[i]);
            int b = Integer.parseInt(split2[i]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        if (split1.length > split2.length) {
            return compare(split1, split2.length);
        } else if (split2.length > split1.length) {
            return compare(split2, split1.length) * -1;
        }
        return 0;
    }

    private int compare(String[] version, int start) {
        for (int i = start; i < version.length; i++) {
            if (Integer.parseInt(version[i]) > 0) {
                return 1;
            }
        }
        return 0;
    }

    // 字符串分割
    public int compareVersion2(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        for (int i = 0; i < split1.length || i < split2.length; i++) {
            int x = 0, y = 0;
            if (i < split1.length) {
                x = Integer.parseInt(split1[i]);
            }
            if (i < split2.length) {
                y = Integer.parseInt(split2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    // 双指针
    public int compareVersion3(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; i++) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++;
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; j++) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            j++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
