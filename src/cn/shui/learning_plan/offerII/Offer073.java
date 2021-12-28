package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/28.
 * @time 10:41.
 * 狒狒吃香蕉
 */
public class Offer073 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = max(piles);
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (countTime(piles, mid) <= h) {
                if (mid == 1 || countTime(piles, mid - 1) > h) {
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int countTime(int[] piles, int k) {
        int t = 0;
        for (int pile : piles) {
            t += pile / k;
            t += pile % k > 0 ? 1 : 0;
        }
        return t;
    }

    private int max(int[] piles) {
        int ans = Integer.MIN_VALUE;
        for (int pile : piles) {
            ans = Math.max(pile, ans);
        }
        return ans;
    }
}
