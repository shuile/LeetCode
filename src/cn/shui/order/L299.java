package cn.shui.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/11/8.
 * @time 09:34.
 * 猜数字游戏
 */
public class L299 {
    public String getHint(String secret, String guess) {
        int countA = 0, countB = 0, len = secret.length();
        Map<Character, Integer> mapSecret = new HashMap<>();
        Map<Character, Integer> mapGuess = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c1 = secret.charAt(i), c2 = guess.charAt(i);
            if (c1 == c2) {
                countA++;
            } else {
                mapSecret.put(c1, mapSecret.getOrDefault(c1, 0) + 1);
                mapGuess.put(c2, mapGuess.getOrDefault(c2, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : mapGuess.entrySet()) {
            if (mapSecret.containsKey(entry.getKey())) {
                countB += Math.min(entry.getValue(), mapSecret.get(entry.getKey()));
            }
        }
        return countA + "A" + countB + "B";
    }
}
