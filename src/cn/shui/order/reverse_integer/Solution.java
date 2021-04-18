package cn.shui.order.reverse_integer;

public class Solution {

    public static void main( String[] args ) {
        System.out.println(reverse(120));
    }

    public static int reverse( int x ) {
        long temp;
        long[] nums = new long[1000];
        int count = -1;
        int flag = 0;

        if ( x >= 0 ) {
            flag = 1;
        } else {
            flag = -1;
        }

        temp = (( long ) x ) * flag;

        while ( temp != 0 ) {
             nums[ ++count ] = temp % 10;
             temp /= 10;
        }

        for ( int i = 0 ; count >= 0 ;  ) {
            temp += nums[ i++ ] * Math.pow( 10, count-- );
        }

        int result;
        if ( temp > Integer.MAX_VALUE ) {
            result = 0;
        } else {
            result = ( int ) temp;
        }
        return result * flag;
    }
}
