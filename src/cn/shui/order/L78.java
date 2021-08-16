package cn.shui.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shui.
 * @date 2021/8/16.
 * @time 21:15.
 * 子集
 */
public class L78 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums == null || nums.length < 1) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length, start = 0, curLen = 0;
        while (curLen < len) {
            int size = ans.size();
            for (int i = start; i < size; i++) {
                List<Integer> list = new ArrayList<>(ans.get(i));
                int index = -1;
                if (list.size() > 0) {
                    index = findIndex(nums, list.get(curLen - 1));
                }
                for (int j = index + 1; j < len; j++) {
                    list.add(nums[j]);
                    ans.add(new ArrayList<>(list));
                    list.remove(curLen);
                }
            }
            start = size;
            curLen = ans.get(ans.size() - 1).size();
        }
        return ans;
    }

    private int findIndex(int[] nums, int n) {
        int l = 0, r = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == n) {
                return mid;
            }
            if (nums[mid] < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private List<Integer> t = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    // 迭代法实现子集枚举
    public List<List<Integer>> subsets2(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    // 递归法实现子集枚举
    public List<List<Integer>> subset2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
