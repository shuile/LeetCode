package cn.shui.labuladong;

import cn.shui.labuladong.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/5/19
 * N叉树的后续遍历
 */
public class L590 {

    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> postOrder(Node root) {
        dfs(root);
        return ans;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                dfs(node);
            }
        }
        ans.add(root.val);
    }
}
