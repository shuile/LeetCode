package roamn_to_integer;

public class Solution {

    public static void main( String[] args ) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt( String s ) {
        char[] symbol = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int[] value = { 1, 5, 10, 50, 100, 500, 1000};
        char[] sToChar = s.toCharArray();
        int[] sToInt = new int[1000];
        for ( int i = 0 ; i < s.length() ; i++ ) {
            for ( int j = 0 ; j < symbol.length ; j++ ) {
                if (sToChar[i] == symbol[j]) {
                    sToInt[i] = j;
                    continue;
                }
            }
        }
        int result = 0;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( sToInt[i] - sToInt[i + 1] == -1) {
                if ( sToInt[i] == 0 ) {
                    result += 4;
                } else if ( sToInt[i] == 2 ) {
                    result += 40;
                } else if (sToInt[i] == 4 ) {
                    result += 400;
                }
                i++;
            } else if ( sToInt[i] - sToInt[i+1] == -2 ) {
                if ( sToInt[i] == 0 ) {
                    result += 9;
                } else if ( sToInt[i] == 2 ) {
                    result += 90;
                } else if (sToInt[i] == 4 ) {
                    result += 900;
                }
                i++;
            } else {
                result += value[sToInt[i]];
            }
        }
        return result;
    }
}
