package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/7
 * 比较版本号
 */
public class L165 {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int idx1 = 0, idx2 = 0;
        int v1, v2;
        while (idx1 < len1 && idx2 < len2) {
            int start = idx1;
            while (idx1 < len1 && version1.charAt(idx1) != '.') {
                idx1++;
            }
            int end = idx1;
            v1 = Integer.parseInt(version1.substring(start, end));
            start = idx2;
            while (idx2 < len2 && version2.charAt(idx2) != '.') {
                idx2++;
            }
            end = idx2;
            v2 = Integer.parseInt(version2.substring(start, end));
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            idx1++;
            idx2++;
        }
        char ch;
        while (idx1 < len1) {
            ch = version1.charAt(idx1++);
            if (ch != '.' && ch != '0') {
                return 1;
            }
        }
        while (idx2 < len2) {
            ch = version2.charAt(idx2++);
            if (ch != '.' && ch != '0') {
                return -1;
            }
        }
        return 0;
    }

    // 双指针
    public int compareVersion2(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            int x = 0;
            for (; i < len1 && version1.charAt(i) != '.'; i++) {
                x = x * 10 + (version1.charAt(i) - '0');
            }
            i++;
            int y = 0;
            for (; j < len2 && version2.charAt(j) != '.'; j++) {
                y = y * 10 + (version2.charAt(j) - '0');
            }
            j++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
