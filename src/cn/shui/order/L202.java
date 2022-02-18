package cn.shui.order;

import cn.shui.learning_plan.datastruct.ninth.L20;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2022/2/18.
 * @time 09:55.
 * 快乐数
 */
public class L202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int temp = 0;
            while (n != 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public static void main(String[] args) {
        L202 test = new L202();
        System.out.println(test.isHappy(2));
    }

    // 快慢指针
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy2(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
}
