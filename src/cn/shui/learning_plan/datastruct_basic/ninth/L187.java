package cn.shui.learning_plan.datastruct_basic.ninth;

import java.util.*;

/**
 * @author shui.
 * @date 2021/9/10.
 * @time 16:29.
 * 重复的DNA序列
 */
public class L187 {

    public static void main(String[] args) {
        L187 test = new L187();
        System.out.println(test.findRepeatedDnaSequences1("AAAAAAAAAAA"));
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return ans;
        }
        if (s.length() == 10) {
            ans.add(s);
            return ans;
        }
        String pre = null;
        int len = s.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len - 10; i++) {
            pre = s.substring(i, i + 10);
            for (int j = i + 1; j < len - 10; j++) {
                if (pre.equals(s.substring(j, j + 10))) {
                    set.add(pre);
                    break;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }

    // 线性时间窗口切片+HashSet
    public List<String> findRepeatedDnaSequences2(String s) {
        int L = 10, n = s.length();
        Set<String> seen = new HashSet<>(), output = new HashSet<>();
        // iterator over all sequences of length L
        for (int start = 0; start < n - L + 1; start++) {
            String tmp = s.substring(start, start + L);
            if (seen.contains(tmp)) {
                output.add(tmp);
            }
            seen.add(tmp);
        }
        return new ArrayList<>(output);
    }

    // rabin-Karp:使用旋转哈希实现常数时间窗口切片
    public List<String> findRepeatedDnaSequences3(String s) {
        int L = 10, n = s.length();
        if (n < L) {
            return new ArrayList<>();
        }

        // rolling hash parameters: base a
        int a = 4, aL = (int) Math.pow(a, L);

        // covert string to array of integers
        Map<Character, Integer> toInt = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = toInt.get(s.charAt(i));
        }
        int h = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();
        // iterator over all sequences of length L
        for (int start = 0; start < n - L + 1; start++) {
            if (start != 0) { // compute hash of the current sequence in O(1) time
                h = h * a - nums[start - 1] * aL + nums[start + L - 1];
            } else { // compute hash of the first sequence in O(L) time
                for (int i = 0; i < L; i++) {
                    h  = h * a + nums[i];
                }
            }
            // update output and hashset of seen sequences
            if (seen.contains(h)) {
                output.add(s.substring(start, start + L));
            }
            seen.add(h);
        }
        return new ArrayList<>(output);
    }
}
