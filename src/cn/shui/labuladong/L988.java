package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/28
 * 从叶节点开始的最小字符串
 */
public class L988 {
    private String ans = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder curr) {
        if (root == null) {
            return;
        }
        curr.append((char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            String str = curr.reverse().toString();
            if (ans.equals("")) {
                ans = str;
            } else {
                if (ans.compareTo(str) > 0) {
                    ans = str;
                }
            }
            curr.reverse();
        } else {
            dfs(root.left, curr);
            dfs(root.right, curr);
        }
        curr.deleteCharAt(curr.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.left.right.left = new TreeNode(0);
        L988 test = new L988();
        test.smallestFromLeaf(root);
    }
}
