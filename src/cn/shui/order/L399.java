package cn.shui.order;

import java.util.*;

/**
 * Created by chenyiting on 2025/4/8
 */
public class L399 {
    /**
     * BFS
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1 / values[i]));
        }

        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0));
                int ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(ia);
                    double[] rations = new double[nvars];
                    Arrays.fill(rations, -1.0);
                    rations[ia] = 1.0;

                    while (!points.isEmpty() && rations[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (rations[y] < 0) {
                                rations[y] = rations[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = rations[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }

    private static class Pair {
        int index;
        double value;

        public Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("x1");
        equation1.add("x2");
        equations.add(equation1);
        List<String> equation2 = new ArrayList<>();
        equation2.add("x2");
        equation2.add("x3");
        equations.add(equation2);
        List<String> equation3 = new ArrayList<>();
        equation3.add("x3");
        equation3.add("x4");
        equations.add(equation3);
        List<String> equation4 = new ArrayList<>();
        equation4.add("x4");
        equation4.add("x5");
        equations.add(equation4);

        double[] values = new double[]{3.0, 4.0, 5.0, 6.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> query = new ArrayList<>();
        query.add("x1");
        query.add("x5");
        queries.add(query);
        List<String> query1 = new ArrayList<>();
        query1.add("x5");
        query1.add("x2");
        queries.add(query1);
        List<String> query2 = new ArrayList<>();
        query2.add("x2");
        query2.add("x4");
        queries.add(query2);
        List<String> query3 = new ArrayList<>();
        query3.add("x2");
        query3.add("x2");
        queries.add(query3);
        List<String> query4 = new ArrayList<>();
        query4.add("x2");
        query4.add("x9");
        queries.add(query4);
        List<String> query5 = new ArrayList<>();
        query5.add("x9");
        query5.add("x9");
        queries.add(query5);

        L399 test = new L399();
        System.out.println(Arrays.toString(test.calcEquation(equations, values, queries)));
    }
}
