package cn.shui.learning_plan.datastruct.sixth;

import java.util.*;

/**
 * @author shui.
 * @date 2021/8/21.
 * @time 22:20.
 * 字符串中的第一个唯一字符
 */
public class L387 {
    public int firstUniqChar1(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        List<Character> chList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        List<Integer> firstIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chList.contains(ch)) {
                int index = chList.indexOf(ch);
                countList.set(index, countList.get(index) + 1);
            } else {
                chList.add(ch);
                countList.add(1);
                firstIndex.add(i);
            }
        }
        for (int i = 0; i < countList.size(); i++) {
            if (countList.get(i) == 1) {
                return firstIndex.get(i);
            }
        }
        return -1;
    }

    // 使用哈希表存储频数
    public int firstUniqChar2(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // 使用哈希表存储索引
    public int firstUniqChar3(String s) {
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
        return first == n ? -1 : first;
    }

    // 队列
    public int firstUniqChar4(String s) {
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
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    class Pair {
        char ch;
        int pos;

        public Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
}
