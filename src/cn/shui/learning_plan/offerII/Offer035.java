package cn.shui.learning_plan.offerII;

import java.util.*;

/**
 * @author shui.
 * @date 2021/12/16.
 * @time 16:33.
 * 最小时间差
 */
public class Offer035 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        Offer035 test = new Offer035();
        test.findMinDifference(list);
    }

    public int findMinDifference(List<String> timePoints) {
        String[] timeStrs = timePoints.toArray(new String[]{});
        Arrays.sort(timeStrs, (o1, o2) -> {
            String[] split1 = o1.split(":");
            String[] split2 = o2.split(":");
            int h1 = Integer.parseInt(split1[0]);
            int h2 = Integer.parseInt(split2[0]);
            if (h1 != h2) {
                return h1 - h2;
            }
            int min1 = Integer.parseInt(split1[1]);
            int min2 = Integer.parseInt(split2[1]);
            return min1 - min2;
        });
        int min = Integer.MAX_VALUE;
        String[] split1 = new String[2], split2 = new String[2];
        for (int i = 0; i < timeStrs.length - 1; i++) {
            if (i == 0) {
                split1 = timeStrs[i].split(":");
            } else {
                split1 = split2;
            }
            split2 = timeStrs[i + 1].split(":");
            int h1 = Integer.parseInt(split1[0]);
            int h2 = Integer.parseInt(split2[0]);
            int min1 = Integer.parseInt(split1[1]);
            int min2 = Integer.parseInt(split2[1]);
            int sum = (h2 - h1) * 60 + min2 - min1;
            min = Math.min(sum, min);
            min = Math.min(min, 1440 - sum);
            if (min == 0) {
                return 0;
            }
        }
        split1 = timeStrs[0].split(":");
        split2 = timeStrs[timeStrs.length - 1].split(":");
        int h1 = Integer.parseInt(split1[0]);
        int h2 = Integer.parseInt(split2[0]);
        int min1 = Integer.parseInt(split1[1]);
        int min2 = Integer.parseInt(split2[1]);
        int sum = (h2 - h1) * 60 + min2 - min1;
        min = Math.min(sum, min);
        min = Math.min(min, 1440 - sum);
        return min;
    }

    public int findMinDifference2(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        List<Integer> mins = new ArrayList<>();
        for (String t : timePoints) {
            String[] time = t.split(":");
            mins.add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        Collections.sort(mins);
        mins.add(mins.get(0) + 24 * 60);
        int res  =24 * 60;
        for (int i = 1; i < mins.size(); i++) {
            res = Math.min(res, mins.get(i) - mins.get(i - 1));
        }
        return res;
    }
}
