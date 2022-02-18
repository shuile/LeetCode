package cn.shui.order;

/**
 * @author shui.
 * @date 2022/2/18.
 * @time 10:13.
 * 找出星型图的中心节点
 */
public class L1791 {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
