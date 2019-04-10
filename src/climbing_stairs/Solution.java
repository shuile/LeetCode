package climbing_stairs;

public class Solution {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    //
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}


/*
    1  11   1
    2  21 12    2
    3  31 1112 1211 3
    4  41 2112 111211 1221 22   5
    5  51 3112 211211 111221 1231 1122 121112 2211 8
    6  61 1   4112 5   2122 6   32 1    13
    7  71 1   5112 6   3122 10   1132 4     21
    8  81 1   6112 7   4122 15   2132 10   42 1     34
    9  91 1   7112 8   5122 21   3132 20   1142 5      55
    10 101 1   8112 9   6122 28   4132 35   2142 15   52 1      89



 */
