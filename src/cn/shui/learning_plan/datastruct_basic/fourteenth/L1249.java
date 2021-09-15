package cn.shui.learning_plan.datastruct_basic.fourteenth;

import java.util.*;

/**
 * @author shui.
 * @date 2021/9/15.
 * @time 11:10.
 * 移除无效的括号
 */
public class L1249 {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('a', 1);
            put('b', 2);
            put('c', 3);
            put('d', 2);
            put('e', 1);
            put('f', 0);
        }};
        Integer[] indexes = new Integer[map.size()];
        map.values().toArray(indexes);
        System.out.println(Arrays.toString(indexes));
        Arrays.sort(indexes);
        System.out.println(Arrays.toString(indexes));

        String s = ")(";
        System.out.println(s.substring(1, 1));

        System.out.println(minRemoveToMakeValid1("))(("));
    }

    public static String minRemoveToMakeValid1(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                map.put(i, ch);
            } else if (ch == ')') {
                if (map.containsValue('(')) {
                    int maxIndex = Integer.MIN_VALUE;
                    for (Map.Entry<Integer, Character> entry : map.entrySet()) {
                        if (entry.getValue() == '(') {
                            maxIndex = Math.max(maxIndex, entry.getKey());
                        }
                    }
                    map.remove(maxIndex, '(');
                } else {
                    map.put(i, ch);
                }
            }
        }
        Integer[] indexes = new Integer[map.size()];
        map.keySet().toArray(indexes);
        Arrays.sort(indexes);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < indexes.length; i++) {
            if (i == 0) {
                ans.append(s, 0, indexes[i]);
            } else {
                ans.append(s, indexes[i - 1] + 1, indexes[i]);
            }
        }
        if (indexes.length < 1) {
            ans.append(s);
        } else {
            ans.append(s, indexes[indexes.length - 1] + 1, s.length());
        }
        return ans.toString();
    }

    // 使用栈和StringBuilder
    public String minRemoveToMakeValid2(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    // 使用StringBuilder的两步法
    public String minRemoveToMakeValid3(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();
    }

    private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;
            } else if (c == close){
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }

    // 改进的使用StringBuilder的两步法
    public String minRemoveToMakeValid4(String s) {
        // Parse 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c =='(') {
                openSeen++;
                balance++;
            } else if (c == ')') {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }

        // Parse 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) {
                    continue;
                }
            }
            result.append(c);
        }
        return result.toString();
    }
}
