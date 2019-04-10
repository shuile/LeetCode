package sqrt_x;

public class Solution {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    //
    public static int mySqrt(int x) {
//        return (int)Math.sqrt(x);
        int result = 0;
        for (int i = 0; i <= x; i++) {
            if (i * i > x) {
                result = i - 1;
                break;
            } else if (i * i == x) {
                result = i;
                break;
            }
        }
        return result;
    }
}
