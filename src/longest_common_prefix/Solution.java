package longest_common_prefix;

public class Solution {

    public static void main( String[] args ) {

        String[] strs = {};
        System.out.println(longestCommonPrefix(strs));
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
}
