package cn.shui.learning_plan.offerII;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author shui.
 * @date 2021/12/23.
 * @time 09:51.
 * 和最小的k个数对
 */
public class Offer061 {

    public static void main(String[] args) {
        Offer061 test = new Offer061();
        int[] nums1 = {0, 0, 0, 0, 0, 2, 2, 2, 2};
        int[] nums2 = {-3, 22, 35, 56, 76};
        int k = 22;
        test.kSmallestPairs(nums1, nums2, k);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        int len1 = Math.min(nums1.length, k);
        int len2 = Math.min(nums2.length, k);
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (sum.size() == k && nums1[i] + nums2[j] >= sum.get(k - 1)) {
                    break;
                }
                addData(ans, sum, nums1[i], nums2[j], k);
            }
        }
        return ans;
    }

    private void addData(List<List<Integer>> ans, List<Integer> sum, int a, int b, int k) {
        if (sum.size() == k) {
            if (a + b >= sum.get(k - 1)) {
                return;
            }
            sum.remove(k - 1);
            ans.remove(k - 1);
        }
        int l = 0, r = sum.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (sum.get(mid) == a + b) {
                if (ans.get(mid).get(0) > a) {
                    r = mid - 1;
                } else if (ans.get(mid).get(0) < a) {
                    l = mid + 1;
                } else {
                    l = mid;
                    break;
                }
            } else if (sum.get(mid) > a + b) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        sum.add(l, a + b);
        ans.add(l, Arrays.asList(a, b));
    }

    // 大顶堆
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        // 创建一个大顶堆，堆中元素排序按照数对和进行逆序排序
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((pair1, pair2) -> pair2.get(0) + pair2.get(1) - pair1.get(0) - pair1.get(1));
        // 数组1取前k个数(长度小于k则取n个，数组2页相同),组成k*k个数对
        int len1 = Math.min(nums1.length, k);
        int len2 = Math.min(nums2.length, k);
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // 将数对加入大顶堆
                queue.add(Arrays.asList(nums1[i], nums2[j]));
                // 如果大顶堆中的元素总量超过k，则将大顶堆的对顶元素删除
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return new ArrayList<>(queue);
    }

    // 小顶堆
    public List<List<Integer>> kSmallestPairs3(int[] nums1, int[] nums2, int k) {
        // 创建一个小顶堆
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((pair1, pair2) -> nums1[pair1.get(0)] + nums2[pair1.get(1)] - nums1[pair2.get(0)] - nums2[pair2.get(1)]);
        // 对小顶堆进行初始化，将<0,0>,...,<k-1,0>插入栈中(如果长度n小于k，则取n个)
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.add(Arrays.asList(i, 0));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (; k > 0 && !queue.isEmpty(); k--) {
            // 选出和最小的数对[i,j](堆顶)，将堆顶弹出
            List<Integer> pair = queue.poll();
            ans.add(Arrays.asList(nums1[pair.get(0)], nums2[pair.get(1)]));
            if (pair.get(1) < nums2.length - 1) {
                queue.add(Arrays.asList(pair.get(0), pair.get(1) + 1));
            }
        }
        return ans;
    }
}
