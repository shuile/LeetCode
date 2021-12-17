package cn.shui.learning_plan.offerII;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/12/17.
 * @time 15:55.
 * 矩阵中最大的矩形
 */
public class Offer040 {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int len = matrix[0].length();
        int[] heights = new int[len];
        int max = 0;
        for (String s : matrix) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += s.charAt(j) - '0';
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                    int height = heights[stack.pop()];
                    int width = i - stack.peek() - 1;
                    max = Math.max(max, height * width);
                }
                stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            max = Math.max(max, height * width);
        }
        return max;
    }
}
