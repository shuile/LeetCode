package cn.shui.order;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chenyiting on 2023/8/3
 * 有序矩阵中第k小的元素
 */
public class L378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        int row = matrix.length;
        for (int num : matrix[0]) {
            if (pq.size() >= k) {
                if (pq.peek() <= num) {
                    break;
                }
                pq.poll();
            }
            pq.offer(num);
        }
        for (int i = 1; i < row; i++) {
            for (int num : matrix[i]) {
                if (pq.size() >= k) {
                    if (pq.peek() <= num) {
                        break;
                    }
                    pq.poll();
                }
                pq.offer(num);
            }
        }
        return pq.peek();
    }

    /**
     * 二分查找
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1, j = 0, num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        L378 test = new L378();
        System.out.println(test.kthSmallest(new int[][]{{1, 2}, {1, 3}}, 2));
    }
}
