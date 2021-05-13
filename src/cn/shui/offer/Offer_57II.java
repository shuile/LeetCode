package cn.shui.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer_57II {
    public static void main(String[] args) {

    }

    private int[][] findContinuousSequence(int target) {
        if (target <= 0) {
            return new int[0][0];
        }
        List<List<Integer>> ans = new ArrayList<>();
        int start = 1;
        while (start < target) {
            List<Integer> list = new ArrayList<>();
            int tmp = start, sum = 0;
            while (sum < target) {
                list.add(tmp);
                sum += tmp;
                tmp++;
            }
            if (sum == target) {
                ans.add(list);
            }
            start++;
        }
        if (ans.size() == 0) {
            return new int[0][0];
        }
        int[][] ret = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> list = ans.get(i);
            int[] tmp = new int[list.size()];
            Integer[] integers = new Integer[list.size()];
            list.toArray(integers);
            for (int j = 0;  j < list.size(); j++) {
                tmp[j] = integers[j];
            }
            ret[i] = tmp;
        }
        return ret;
    }

    private int[][] findContinuousSequence2(int target) {
        List<int[]> vec = new ArrayList<>();
        int sum = 0, limit = (target - 1) / 2;
        for (int i = 1; i <= limit; i++) {
            for (int j = i;;j++) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    private int[][] findContinuousSequence3(int target) {
        List<int[]> vec = new ArrayList<>();
        int limit = (target - 1) / 2;
        for (int x = 1; x <= limit; x++) {
            long delta = 1 - 4 * (x - (long) x * x - 2 * target);
            if (delta < 0) {
                continue;
            }
            int delta_sqrt = (int) Math.sqrt(delta + 0.5);
            if ((long) delta_sqrt * delta_sqrt == delta && (delta_sqrt - 1) % 2 == 0) {
                int y = (-1 + delta_sqrt) / 2;
                if (x < y) {
                    int[] res = new int[y - x + 1];
                    for (int i = x; i <= y; i++) {
                        res[i - x] = i;
                    }
                    vec.add(res);
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    private int[][] findContinuousSequence4(int target) {
        List<int[]> vec = new ArrayList<>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
