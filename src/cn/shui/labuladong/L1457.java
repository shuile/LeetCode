package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/31
 * 二叉树中伪回文路径
 */
public class L1457 {

    private final int[] arr = new int[10];
    private int countOdd = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        add(root.val);
        if (root.left == null && root.right == null) {
            ans = countOdd > 1 ? 0 : -1;
        } else {
            ans = dfs(root.left) + dfs(root.right);
        }
        minus(root.val);
        return ans;
    }

    private void add(int index) {
        arr[index]++;
        calculate(index);
    }

    private void minus(int index) {
        arr[index]--;
        calculate(index);
    }

    private void calculate(int index) {
        countOdd += arr[index] % 2 == 0 ? -1 : 1;
    }
}
