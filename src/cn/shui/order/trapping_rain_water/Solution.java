package cn.shui.order.trapping_rain_water;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int trap = 0;
        if (height == null || height.length == 0) {
            return trap;
        }
        int size = height.length;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = height[0];
        for (int i = 1; i < size; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        right[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        for (int i = 0; i < size; i++) {
            trap += Math.min(left[i], right[i]) - height[i];
        }
        return trap;
    }

    private static int trap1(int[] height) {
        int trap = 0;
        if (height == null || height.length == 0) {
            return trap;
        }
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int top = stack.peek();
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                trap += distance * boundedHeight;
            }
            stack.push(current++);
        }
        return trap;
    }

    private static int trap2(int[] height) {
        int trap = 0;
        if (height == null || height.length == 0) {
            return trap;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trap += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trap += rightMax - height[right];
                }
                right--;
            }
        }
        return trap;
    }
}
