package cn.shui.learning_plan.offer.sixteenth;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shui.
 * @date 2021/10/16.
 * @time 09:45.
 */
public class Offer45 {

    public static void main(String[] args) {
        Offer45 test = new Offer45();
        test.minNumber(new int[]{3, 30, 34, 5, 9});
    }

    // 部分正确
    public String minNumber(int[] nums) {
        if (nums.length == 1) {
            return "" + nums[0];
        }
        int len = nums.length;
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = "" + nums[i];
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // o1 == o2
                if (o1 == o2 || o1.equals(o2)) {
                    return 0;
                }
                int len = Math.min(o1.length(), o2.length());
                int flag = 1;
                for (int i = 0; i < len; i++) {
                    if (o1.charAt(i) == o2.charAt(i)) {
                        flag = 0;
                        continue;
                    }
                    if (o1.charAt(i) > o2.charAt(i)) {
                        flag = 1;
                    } else {
                        flag = -1;
                    }
                }
                if (flag == 0) {
                    if (o1.length() > len) {
                        flag = o1.charAt(len) > o2.charAt(len - 1) ? 1 : -1;
                    } else {
                        flag = o1.charAt(len - 1) > o2.charAt(len) ? 1 : -1;
                    }
                }
                return flag;
            }
        });
        StringBuilder ans = new StringBuilder();
        for (String s : str) {
            ans.append(s);
        }
        return ans.toString().trim();
    }

    // 快速排序
    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) {
                i++;
            }
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

    // 内置函数
    public String minNumber3(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder ans = new StringBuilder();
        for (String str : strs) {
            ans.append(str);
        }
        return ans.toString();
    }
}
