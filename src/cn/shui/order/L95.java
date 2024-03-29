package cn.shui.order;

import cn.shui.order.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/10/27.
 * @time 09:50.
 */
public class L95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start >  end) {
            allTrees.add(null);
            return allTrees;
        }
        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            // 从左子树集合中选出一颗左子树，从右子树集合中选出一颗右子树，拼接到根节点上
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = leftTree;
                    currTree.right = rightTree;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
