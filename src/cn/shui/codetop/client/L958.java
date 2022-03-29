package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/3/28
 * 二叉树的完全性校验
 */
public class L958 {
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> list = new ArrayList<>();
        list.add(new ANode(root, 1));
        int i = 0;
        while (i < list.size()) {
            ANode node = list.get(i++);
            if (node.node != null) {
                list.add(new ANode(node.node.left, node.code * 2));
                list.add(new ANode(node.node.right, node.code * 2 + 1));
            }
        }
        return list.get(list.size() - 1).code == list.size();
    }

    private static class ANode {
        public TreeNode node;
        public int code;

        public ANode() {
        }

        public ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }
}
