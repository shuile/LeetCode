package cn.shui.order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenyiting on 2025/4/10
 * Binary Watch
 */
public class L401 {

    private static final int[] HOURS = {1, 2, 4, 8};
    private static final int[] MINUTES = {1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn < 0 || turnedOn > 10) {
            return new ArrayList<>();
        }
        Set<String> ans = new HashSet<>();
        help(ans, turnedOn, 0, 0, HOURS, MINUTES);
        return ans.stream().toList();
    }

    private void help(Set<String> ans, int turnedOn, int hour, int minute, int[] hours, int[] minutes) {
        if (turnedOn == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            if (minute < 10) {
                sb.append("0");
            }
            sb.append(minute);
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < minutes.length; i++) {
            if (minute + minutes[i] > 59) {
                break;
            }
            int[] tmpMinutes = new int[minutes.length - i - 1];
            System.arraycopy(minutes, i + 1, tmpMinutes, 0, tmpMinutes.length);
            help(ans, turnedOn - 1, hour, minute + minutes[i], hours, tmpMinutes);
        }
        for (int i = 0; i < hours.length; i++) {
            if (hour + hours[i] > 11) {
                break;
            }
            int[] tmpHours = new int[hours.length - i - 1];
            System.arraycopy(hours, i + 1, tmpHours, 0, tmpHours.length);
            help(ans, turnedOn - 1, hour + hours[i], minute, tmpHours, minutes);
        }
    }

    public static void main(String[] args) {
        L401 test = new L401();
        List<String> ans = test.readBinaryWatch(2);
        System.out.println(ans);
    }
}
