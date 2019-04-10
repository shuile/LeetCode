package count_and_say;

public class Solution {

    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            System.out.println(countAndSay(i));
        }
    }

    //生成循环序列
    public static String countAndSay(int n) {
        String result = "1";
        String str = "";
        int count = 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            while (index < result.length()) {
                char ch = result.charAt(index);
                while (index < result.length() && ch == result.charAt(index)) {
                    count++;
                    index++;
                }
                str += "" + count + ch;
                count = 0;
            }
            index = 0;
            result = str;
            str = "";
        }
        return result;
    }
}
