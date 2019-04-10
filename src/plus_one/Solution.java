package plus_one;

public class Solution {

    public static void main(String[] args) {
        int[] n1 = {6, 1, 4, 5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        int[] r = plusOne(n1);
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }

    //
    public static int[] plusOne(int[] digits) {
        int[] result;
        boolean isAllNine = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                isAllNine = false;
            }
        }
        if (isAllNine) {
            result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i< result.length; i++) {
                result[i] = 0;
            }
        } else {
            result = digits;
            for (int i = result.length - 1; i >= 0; i--) {
                if (result[i] == 9) {
                    result[i] = 0;
                } else {
                    result[i]++;
                    break;
                }
            }
        }
        return result;
    }
}
