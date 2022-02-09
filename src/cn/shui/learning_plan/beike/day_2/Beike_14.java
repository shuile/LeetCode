package cn.shui.learning_plan.beike.day_2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shui.
 * @date 2022/2/9.
 * @time 09:38.
 * 最长公共前缀
 */
public class Beike_14 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = compareStr(prefix, strs[i]);
        }
        return prefix;
    }

    private String compareStr(String str1, String str2) {
        String strShort = str1.length() > str2.length() ? str2 : str1;
        String strLong = str1.length() > str2.length() ? str1 : str2;
        int len = strShort.length();
        for (int i = 0; i < strShort.length(); i++) {
            if (strLong.startsWith(strShort.substring(0, len - i))) {
                return strShort.substring(0, len - i);
            }
        }
        return "";
    }

    // 横向扫描
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    // 纵向扫描
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // 分治
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = start + (end - start) / 2;
        String lcpLeft = longestCommonPrefix(strs, start, mid);
        String lcpRight = longestCommonPrefix(strs, mid + 1, end);
        return commonPrefix(lcpLeft, lcpRight);
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    // 二分查找
    public String longestCommonPrefix5(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
