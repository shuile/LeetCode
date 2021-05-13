package cn.shui.offer;

public class Offer_58I {
    public static void main(String[] args) {

    }

    private String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] split = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].equals("")) {
                continue;
            }
            sb.append(split[i]).append(" ");
        }
        return sb.toString().trim();
    }

    private String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }
}
