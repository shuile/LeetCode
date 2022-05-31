package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/31
 * 找出克隆二叉树中的相同节点
 */
public class L1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode ans = getTargetCopy(original.left, cloned.left, target);
        return ans == null ? getTargetCopy(original.right, cloned.right, target) : ans;
    }
}
