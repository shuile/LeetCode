package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/12/21.
 * @time 11:41.
 * 二叉搜索树中两个节点只和
 */
public class Offer056 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }
        boolean result = dfs(node.left, k, set);
        if (result) {
            return true;
        }
        if (set.contains(node.val)) {
            return true;
        }
        set.add(k - node.val);
        return dfs(node.right, k, set);
    }
}
