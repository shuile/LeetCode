package cn.shui.labuladong.model;

import java.util.List;

/**
 * Created by chenyiting on 2022/5/19
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
