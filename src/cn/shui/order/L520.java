package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/13.
 * @time 15:09.
 * 检测大写字母
 */
public class L520 {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() < 1) {
            return true;
        }
        boolean firstCapital = false, secondCapital = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (i == 0) {
                firstCapital = isCapital(ch);
                continue;
            }
            if (i == 1) {
                secondCapital = isCapital(ch);
                if (!firstCapital && secondCapital) {
                    return false;
                }
                continue;
            }
            if (isCapital(ch) != secondCapital) {
                return false;
            }
        }
        return true;
    }

    private boolean isCapital(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public boolean detectCapitalUse2(String word) {
        // 若第1个字母为小写，则需额外判断第2个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        // 无论第1个字母是否小大写，其他字母必须与第2个字母相同
        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }
}
