package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2022/5/29
 * 分裂二叉树的最大乘积
 */
public class L1339 {

    private static final TreeNode TEST1 = new TreeNode(1);

    static {
        TEST1.left = new TreeNode(2);
        TEST1.right = new TreeNode(3);
        TEST1.left.left = new TreeNode(4);
        TEST1.left.right = new TreeNode(5);
        TEST1.right.left = new TreeNode(6);
    }

    public static void main(String[] args) {
        L1339 test = new L1339();
        test.maxProduct(TEST1);
    }

    private long treeSum = 0;

    private int maxProduct3(TreeNode root) {
        treeSum = getSum(root);
        getSum(root);
        return (int) (ans % (1e9 + 7));
    }

    private long getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long leftSum = getSum(root.left);
        long rightSum = getSum(root.right);
        long rootSum = leftSum + rightSum + root.val;
        ans = Math.max(ans, rootSum * (treeSum - rootSum));
        return rootSum;
    }

    private final Map<TreeNode, Long> map = new HashMap<>();

    private int maxProduct2(TreeNode root) {
        dfsForSum2(root);
        dfsForSplit2(root, 0);
        return (int) (ans % 1000000007L);
    }

    private long dfsForSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long left = dfsForSum2(root.left);
        long right = dfsForSum2(root.right);
        long res = left + right + root.val;
        map.put(root, res);
        return res;
    }

    private void dfsForSplit2(TreeNode root, long parentSum) {
        if (root == null) {
            return;
        }
        parentSum += root.val;
        long left = map.getOrDefault(root.left, 0L);
        long right = map.getOrDefault(root.right, 0L);
        ans = Math.max(ans, Math.max((parentSum + left) * right, left * (parentSum * right)));
        dfsForSplit2(root.left, parentSum + right);
        dfsForSplit2(root.right, parentSum + left);
    }

    private long ans = 0;

    // 超时
    public int maxProduct(TreeNode root) {
        dfsForSplit(root, 0);
        return (int) (ans % 1000000007L);
    }

    private void dfsForSplit(TreeNode root, long parentSum) {
        if (root == null) {
            return;
        }
        parentSum += root.val;
        long leftSum = dfsForSum(root.left);
        long rightSum = dfsForSum(root.right);
        ans = Math.max(ans, Math.max((parentSum + leftSum) * rightSum, leftSum * (parentSum + rightSum)));
        dfsForSplit(root.left, parentSum + rightSum);
        dfsForSplit(root.right, parentSum + leftSum);
    }

    private long dfsForSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + dfsForSum(root.left) + dfsForSum(root.right);
    }
}
