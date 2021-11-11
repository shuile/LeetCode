package cn.shui.order;

import cn.shui.order.base.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/11/11.
 * @time 09:16.
 * 克隆图
 */
public class L133 {

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        L133 test = new L133();
        test.cloneGraph(node1);
    }

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }
        if (node.neighbors.size() < 1) {
            return new GraphNode(node.val);
        }
        Map<GraphNode, GraphNode> map = new HashMap<>();
        GraphNode newNode = new GraphNode(node.val);
        map.put(node, newNode);
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        GraphNode curr, newCurr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            newCurr = map.get(curr);
            if (curr.neighbors != null && curr.neighbors.size() != newCurr.neighbors.size()) {
                for (GraphNode temp : curr.neighbors) {
                    if (newCurr.neighbors.contains(map.get(temp))) {
                        continue;
                    }
                    GraphNode newTemp;
                    if (map.containsKey(temp)) {
                        newTemp = map.get(temp);
                    } else {
                        newTemp = new GraphNode(temp.val);
                        map.put(temp, newTemp);
                    }
                    newCurr.neighbors.add(newTemp);
                    queue.offer(temp);
                }
            }
        }
        return newNode;
    }

    // 深度优先搜索
    private Map<GraphNode, GraphNode> visited = new HashMap<>();

    public GraphNode cloneGraph2(GraphNode node) {
        if (node == null) {
            return null;
        }
        // 如果节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        GraphNode cloneNode = new GraphNode(node.val);
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (GraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph2(neighbor));
        }
        return cloneNode;
    }

    // 广度优先搜索
    public GraphNode cloneGraph3(GraphNode node) {
        if (node == null) {
            return null;
        }
        Map<GraphNode, GraphNode> visited = new HashMap<>();
        // 想题目给定的节点添加到队列
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        // 克隆以第一个节点并存储到哈希表中
        visited.put(node, new GraphNode(node.val));
        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出队列的头结点
            GraphNode n = queue.poll();
            // 遍历该节点的邻居
            for (GraphNode neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new GraphNode(neighbor.val));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
