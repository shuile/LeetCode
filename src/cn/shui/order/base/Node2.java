package cn.shui.order.base;

import java.util.List;

/**
 * @author shui.
 * @date 2021/11/21.
 * @time 20:45.
 */
public class Node2 {
    private int val;
    public List<Node2> children;

    public Node2() {
    }

    public Node2(int val) {
        this.val = val;
    }

    public Node2(int val, List<Node2> children) {
        this.val = val;
        this.children = children;
    }
}
