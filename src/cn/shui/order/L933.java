package cn.shui.order;

import java.util.LinkedList;

/**
 * Created by chenyiting on 2023/8/10
 * 最近的请求次数
 */
public class L933 {
    private static class RecentCounter {

        private LinkedList<Integer> list;

        public RecentCounter() {
            list = new LinkedList<>();
        }

        public int ping(int t) {
            while (!list.isEmpty() && list.getFirst() < t - 3000) {
                list.removeFirst();
            }
            list.offer(t);
            return list.size();
        }
    }
}
