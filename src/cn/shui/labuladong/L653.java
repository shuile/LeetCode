package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenyiting on 2022/5/24
 * 两数之和IV - 输入BST
 */
public class L653 {

    // dfs + 哈希表
    private final Set<Integer> set = new HashSet<>();

    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget2(root.left, k) || findTarget2(root.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>(dfs(root));
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    private List<Integer> dfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(dfs(root.left));
        list.add(root.val);
        list.addAll(dfs(root.right));
        return list;
    }
}
