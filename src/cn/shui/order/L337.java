package cn.shui.order;

import cn.shui.order.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2023/3/14
 * 打家劫舍III
 */
public class L337 {

    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root.left == null && root.right == null) {
            map.put(root, root.val);
            return root.val;
        }
        int t1 = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int t2 = rob(root.left) + rob(root.right);
        map.put(root, Math.max(t1, t2));
        return Math.max(t1, t2);
    }

    private Map<TreeNode, Integer> f = new HashMap<>();
    private Map<TreeNode, Integer> g = new HashMap<>();

    // 动态规划
    public int rob2(TreeNode root) {
        dfs2(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root.left);
        dfs2(root.right);
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }

    // 动态规划，优化空间
    public int rob3(TreeNode root) {
        int[] rootStatus = dfs3(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    private int[] dfs3(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs3(root.left);
        int[] r = dfs3(root.right);
        int selected = root.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
