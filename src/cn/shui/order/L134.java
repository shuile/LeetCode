package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/11.
 * @time 11:40.
 * 加油站
 */
public class L134 {

    public static void main(String[] args) {
        L134 test = new L134();
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        test.canCompleteCircuit(gas, cost);
    }

    // 超出时间限制
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int distance = gas.length;
        for (int i = 0; i < distance; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            int j = (i + 1) % distance;
            int total = gas[i] - cost[i];
            while (i != j) {
                total += (gas[j] - cost[j]);
                if (total < 0) {
                    break;
                }
                j = (j + 1) % distance;
            }
            if (i == j && total >= 0) {
                return i;
            } else {
                i = j + 1;
            }
        }
        return -1;
    }

    // 一次遍历
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
