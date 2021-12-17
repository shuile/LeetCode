package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/17.
 * @time 09:37.
 * 小行星碰撞
 */
public class Offer037 {

    public static void main(String[] args) {
        Offer037 test = new Offer037();
        test.asteroidCollision(new int[]{1,-2,-1,-1,-2});
    }

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || list.isEmpty()) {
                list.add(asteroids[i]);
            } else {
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j) > 0) {
                        if (list.get(j) > -asteroids[i]) {
                            break;
                        } else if (list.get(j) == -asteroids[i]) {
                            list.remove(j);
                            break;
                        } else {
                            list.remove(j);
                            if (j == 0) {
                                list.add(asteroids[i]);
                                break;
                            }
                        }
                    } else {
                        list.add(asteroids[i]);
                        break;
                    }
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
