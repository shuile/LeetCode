package longest_common_prefix;

public class Solution {

    public static void main( String[] args ) {

        String a = "bb";
        System.out.println(a.substring(0, 2));

        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix( String[] strs ) {

        char[][] strsToChar = new char[strs.length][];

        if (strs.length == 0) {
            return "";
        }

        for ( int i = 0 ; i < strs.length ; i++ ) {
            strsToChar[i] = strs[i].toCharArray();
        }

        String str = "";
        boolean flag = true;

        for ( int i = 0 ; i < strsToChar[0].length ; i++ ) {

            for ( int j = 1 ; j < strs.length ; j++ ) {

                if ( i + 1 > strsToChar[j].length ) {
                    flag = false;
                    break;
                }

                if ( strsToChar[0][i] != strsToChar[j][i] ) {
                    flag = false;
                    break;
                }
            }

            if ( flag ) {
                str += strsToChar[0][i];
            } else {
                break;
            }
        }

        return str;
    }

    public static String longestCommonPrefix2(String[] strs) {
        String prefix = "";
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            len = Math.min(len, strs[i].length());
        }
        for (int i = 0; i <= len; i++) {
            String s = strs[0].substring(0, i);
            boolean isAllMatch = true;
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(s)) {
                    isAllMatch = false;
                }
            }
            if (!isAllMatch) {
                break;
            } else {
                prefix = s;
            }
        }
        return prefix;
    }
}
