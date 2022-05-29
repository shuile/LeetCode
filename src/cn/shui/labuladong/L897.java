package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/30
 * 递增顺序搜索树
 */
public class L897 {

    private static final TreeNode TEST1 = new TreeNode(2);

    static {
        TEST1.left = new TreeNode(1);
        TEST1.right = new TreeNode(4);
        TEST1.right.left = new TreeNode(3);
    }

    public static void main(String[] args) {
        L897 test = new L897();
        test.increasingBST(TEST1);
    }

    private TreeNode first = null;
    private TreeNode last = null;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        last.left = null;
        last.right = null;
        return first;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root == last) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        dfs(left);

        if (first == null) {
            first = root;
        }
        if (last != null) {
            last.left = null;
            last.right = root;
        }
        last = root;

        dfs(right);
    }
}
