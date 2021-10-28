package cn.shui.order;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/10/28.
 * @time 08:44.
 * 重新排序得到2的幂
 */
public class L869 {

    // 搜索回溯 + 位运算
    private boolean[] vis;

    public boolean reorderedPowerOf2(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        return backtrack(nums, 0, 0);
    }

    private boolean backtrack(char[] nums, int idx, int num) {
        if (idx == nums.length) {
            return isPowerOfTwo(num);
        }
        for (int i = 0; i < nums.length; i++) {
            // 不能有前导零
            if ((num == 0 && nums[i] == '0') || vis[i] || (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            vis[i] = true;
            if (backtrack(nums, idx + 1, num * 10 + nums[i] - '0')) {
                return true;
            }
            vis[i] = false;
        }
        return false;
    }

    private boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    // 预处理 + 哈希表
    Set<String> powerOf2Digits = new HashSet<>();

    public boolean reorderedPowerOf2_2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    private void init() {
        for (int n = 1; n <= 1e9; n <<= 1) {
            powerOf2Digits.add(countDigits(n));
        }
    }

    private String countDigits(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return new String(cnt);
    }
}
