package cn.shui.learning_plan.offerII;

import java.util.*;

/**
 * @author shui.
 * @date 2021/12/22.
 * @time 11:40.
 */
public class Offer058 {
    private class MyCalendar {
        private final List<Integer> mStartList;
        private final Map<Integer, Integer> mData;

        public MyCalendar() {
            mStartList = new ArrayList<>();
            mData = new HashMap<>();
        }

        public boolean book(int start, int end) {
            int l = 0, r = mStartList.size() - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int s = mStartList.get(mid);
                if (s > start) {
                    if (s >= end) {
                        r = mid - 1;
                    } else {
                        return false;
                    }
                } else if (s < start) {
                    if (mData.get(s) <= start) {
                        l = mid + 1;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            mStartList.add(l, start);
            mData.put(start, end);
            return true;
        }
    }

    private class MyCalendar2 {

        private final TreeMap<Integer, Integer> events;

        public MyCalendar2() {
            events = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            // ceilingEntry：寻找比key为start的键大的最小键
            Map.Entry<Integer, Integer> event = events.ceilingEntry(start);
            // 与后一个时间段重叠
            if (event != null && event.getKey() < end) {
                return false;
            }
            // floorEntry：寻找比key为start的键小的最大键
            event = events.floorEntry(start);
            // 与前一个时间段重叠
            if (event != null && event.getValue() > start) {
                return false;
            }
            events.put(start, end);
            return true;
        }
    }
}
