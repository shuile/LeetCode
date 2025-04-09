package cn.shui.order;

import java.util.*;

/**
 * Created by chenyiting on 2025/4/3
 */
public class L398 {

    private Map<Integer, List<Integer>> mMap = new HashMap<>();
    private Random mRandom;

    public L398(int[] nums) {
        mRandom = new Random();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = mMap.getOrDefault(nums[i], new ArrayList<>());
            if (tmp.isEmpty()) {
                mMap.put(nums[i], tmp);
            }
            tmp.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> tmp = mMap.get(target);
        if (tmp == null || tmp.isEmpty()) {
            return -1;
        }
        return tmp.get(mRandom.nextInt(tmp.size()));
    }


}
