package cn.shui.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/11/17.
 * @time 10:18.
 * 最大单词长度乘积
 */
public class L318 {

    // 位运算
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] masks = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wordLen = word.length();
            for (int j = 0; j < wordLen; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxPod = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxPod = Math.max(maxPod, words[i].length() * words[j].length());
                }
            }
        }
        return maxPod;
    }

    // 位运算优化
    public int maxProduct2(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            int mask = 0;
            String word = words[i];
            int wordLen = word.length();
            for (int j = 0; j < wordLen; j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            if (wordLen > map.getOrDefault(mask, 0)) {
                map.put(mask, wordLen);
            }
        }
        int maxProd = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int wordLen1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int wordLen2 = map.get(mask2);
                    maxProd = Math.max(maxProd, wordLen1 * wordLen2);
                }
            }
        }
        return maxProd;
    }
}
