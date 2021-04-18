package cn.shui.order.palindrome_number;

public class Solution {

    public static void main( String[] args ) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome( int x ) {
        char[] xStr = String.valueOf(x).toCharArray();
        char[] reXStr = new char[xStr.length];
        for (int i = 0 ; i < xStr.length ; i++ ) {
            reXStr[i] = xStr[xStr.length - i - 1];
        }
        return ( new String( xStr ) ).equals( new String( reXStr ) );
    }
}
