package cn.shui.learning_plan.offer.fifteenth;

import cn.shui.learning_plan.offer.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/10/15.
 * @time 15:08.
 */
public class Offer34 {

    public static void main(String[] args) {
        Offer34 test = new Offer34();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        test.pathSum(root, 22);
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return ans;
        }
        dfs(root, target);
        return ans;
    }

    private void dfs(TreeNode root, int target) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ans.add(new ArrayList<>(list));
            }
        } else {
            if (root.left != null) {
                dfs(root.left, target - root.val);
            }
            if (root.right != null) {
                dfs(root.right, target - root.val);
            }
        }
        list.remove(list.size() - 1);
    }
}
