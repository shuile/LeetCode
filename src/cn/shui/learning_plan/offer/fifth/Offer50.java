package cn.shui.learning_plan.offer.fifth;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/9/29.
 * @time 10:01.
 */
public class Offer50 {

    public static void main(String[] args) {
        String s = "leetcode";
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            System.out.print(sub);
            System.out.println(" " + s.contains(sub));
        }
    }

    public char firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return ' ';
        }
        for (int i = 0; i < s.length(); i++) {
            if (!s.substring(i + 1).contains(s.substring(i, i + 1)) && !s.substring(0, i).contains(s.substring(i, i + 1))) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    // 使用哈希表存储频数
    public char firstUniqChar2(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (frequency.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    // 用哈希表存储索引
    public char firstUniqChar3(String s) {
        Map<Character, Integer> position = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        return first == n ? ' ' : s.charAt(first);
    }

    // 队列
    public char firstUniqChar4(String s) {
        Map<Character, Integer> position = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? ' ' : queue.poll().ch;
    }

    private static class Pair {
        char ch;
        int pos;

        public Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
}
