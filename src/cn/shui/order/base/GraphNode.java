package cn.shui.order.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/11/11.
 * @time 09:18.
 */
public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
