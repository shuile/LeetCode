package cn.shui.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenyiting on 2022/7/6
 * 计数质数
 */
public class L204 {

    private final List<Integer> list = new ArrayList<>();

    // 超时
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int size = list.size();
        if (size > 0 && n <= list.get(size - 1)) {
            int ans = 0;
            for (int a : list) {
                if (a > n) {
                    break;
                }
                ans++;
            }
            return ans;
        }
        int i = size == 0 ? 2 : list.get(size - 1) + 1;
        for (; i < n; i++) {
            if (isPrimes(i)) {
                list.add(i);
            }
        }
        return list.size();
    }

    private boolean isPrimes(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        int sqrt = (int) Math.floor(Math.sqrt(n));
        for (int j = 2; j <= sqrt; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    // 埃氏筛
    private int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                ans++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    // 线氏筛
    private int countPrimes3(int n) {
        List<Integer> primes = new ArrayList<>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        L204 test = new L204();
        System.out.println(test.countPrimes(10));
    }
}
