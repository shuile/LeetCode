package cn.shui.learning_plan.offerII;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/12/27.
 * @time 11:41.
 * 最大的异或
 */
public class Offer067 {
    // 超时
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    private static final int HIGH_BIT = 30;

    // 哈希表
    public int findMaximumXOR2(int[] nums) {
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                seen.add(num >> k);
            }
            int xNext = x * 2 + 1;
            boolean found = false;
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            if (found) {
                x = xNext;
            } else {
                x = xNext - 1;
            }
        }
        return x;
    }

    // 字典树
    private final TrieNode mRoot = new TrieNode();

    public int findMaximumXOR3(int[] nums) {
        int len = nums.length;
        int x = 0;
        for (int i = 1; i < len; i++) {
            // 将nums[i - 1]放入字典树，此时nums[0 .. i-1]都在字典树中
            add(nums[i - 1]);
            // 将nums[i - 1]看作ai，找出最大的x更新答案
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }

    private void add(int num) {
        TrieNode node = mRoot;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (node.left == null) {
                    node.left = new TrieNode();
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TrieNode();
                }
                node = node.right;
            }
        }
    }

    private int check(int num) {
        TrieNode node = mRoot;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i的第k个二进制为0，应当往表示1的子节点right走
                if (node.right != null) {
                    node = node.right;
                    x = x * 2 + 1;
                } else {
                    node = node.left;
                    x = x * 2;
                }
            } else {
                // a_i的第k个二进制位为1，应当往表示0的子节点left走
                if (node.left != null) {
                    node = node.left;
                    x = x * 2 + 1;
                } else {
                    node = node.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }

    private static class TrieNode {
        // 左子树指向表示0的子节点
        TrieNode left;
        // 右子树指向表示1的子节点
        TrieNode right;
    }
}
