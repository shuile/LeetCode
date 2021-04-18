package cn.shui.offer;

public class Offer_05 {
    public static void main(String[] args) {

    }

    private static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
