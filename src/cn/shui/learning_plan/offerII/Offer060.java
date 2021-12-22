package cn.shui.learning_plan.offerII;

import java.util.*;

/**
 * @author shui.
 * @date 2021/12/22.
 * @time 15:56.
 * 出现频率最高的k个数字
 */
public class Offer060 {
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            values.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        qsort(values, 0, values.size() - 1, ans, 0, k);
        return ans;
    }

    private void qsort(List<int[]> values, int start, int end, int[] ans, int ansIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);
        if (k <= index - start) {
            qsort(values, start, index - 1, ans, ansIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ans[ansIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ans, ansIndex, k - (index - start + 1));
            }
        }
    }
}
