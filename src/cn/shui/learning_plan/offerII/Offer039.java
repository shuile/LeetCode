package cn.shui.learning_plan.offerII;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/12/17.
 * @time 14:29.
 * 直方图最大矩形面积
 */
public class Offer039 {
    public int largestRectangle(int[] heights) {
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
