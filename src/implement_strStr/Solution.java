package implement_strStr;

public class Solution {

    public static void main(String[] args) {
        String hay1 = "hello";
        String need1 = "ll";
        String hay2 = "aaaaa";
        String need2 = "bba";
//        System.out.println("hay1 and need1: " + strStr(hay1, need1));
//        System.out.println("hay2 and need2: " + strStr(hay2, need2));
        String h = "mississippi";
        String n = "pi";
        System.out.println("h and n: " + strStr(h, n));
    }

    //字符串匹配
    public static int strStr(String haystack, String needle) {
        int index = -1;
        if (haystack == null || needle == null) {
            return index;
        }
        if (needle.equals("")) {
            index = 0;
            return index;
        }
        if ((haystack.equals("") && !needle.equals(""))) {
            return index;
        }
        if (haystack.length() < needle.length()) {
            return index;
        }
        if (haystack.length() == needle.length()) {
            if (haystack.equals(needle)) {
                index = 0;
            } else {
                index = -1;
            }
            return index;
        }
        if (haystack.length() > needle.length()) {
            for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    String tmp = haystack.substring(i, i + needle.length());
                    if (needle.equals(tmp)) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }
}
