package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/5/31
 * 翻转二叉树以匹配先序遍历
 */
public class L971 {

    private int curr = 0;
    private int[] voyage;
    private List<Integer> ans;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        this.voyage = voyage;
        if (!dfs(root)) {
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != voyage[curr]) {
            return false;
        }
        curr++;
        if (!dfs(root.left)) {
            ans.add(root.val);
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            if (!dfs(root.left)) {
                return false;
            }
        }
        return dfs(root.right);
    }
}
