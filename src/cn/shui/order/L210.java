package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/7/16
 * 课程表II
 */
public class L210 {

    private List<List<Integer>> edges;
    private int[] visited;
    private int[] ans;
    private boolean valid = true;
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        ans = new int[numCourses];
        index = numCourses - 1;
        for (int[] p : prerequisites) {
            edges.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }
        if (!valid) {
            return new int[0];
        }
        return ans;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        ans[index--] = u;
    }
}
