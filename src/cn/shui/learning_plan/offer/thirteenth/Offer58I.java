package cn.shui.learning_plan.offer.thirteenth;

/**
 * @author shui.
 * @date 2021/10/14.
 * @time 14:55.
 */
public class Offer58I {

    public static void main(String[] args) {
        Offer58I test = new Offer58I();
        test.reverseWords("the sky is blue");
    }

    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        String[] splits = s.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--) {
            ans.append(splits[i]).append(" ");
        }
        return ans.toString().trim();
    }

    // 双指针
    public String reverseWords2(String s) {
        s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            res.append(s.substring(i + 1, j + 1) + " ");
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        return res.toString().trim();
    }
}
