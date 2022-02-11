package cn.shui.learning_plan.beike.day_4;

import cn.shui.learning_plan.beike.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2022/2/11.
 * @time 09:35.
 */
public class Beike_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), root, targetSum, 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> path, TreeNode root, int targetSum, int currSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            helper(ans, path, root.left, targetSum, currSum);
            helper(ans, path, root.right, targetSum, currSum);
        }
        path.remove(path.size() - 1);
    }
}
