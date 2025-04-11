package cn.shui.order;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by chenyiting on 2025/4/10
 * Count the Number of Powerful Integers
 */
public class L2999 {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long sLong = Long.parseLong(s);
        String[] s1 = s.split(" ");
        if (sLong > finish) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(" ");
        Random random = new Random();
        System.out.println(splits[random.nextInt(splits.length)]);
    }
}
