package cn.shui.offer;

import java.util.Stack;

public class Offer_31 {
    public static void main(String[] args) {

    }

    private boolean validateStackSequence(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) {
            return true;
        }
        if (pushed != null && popped != null && pushed.length == 0 && popped.length == 0) {
            return true;
        }
        if (pushed == null || pushed.length == 0 || popped == null || popped.length == 0 || pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.add(pushed[0]);
        for (int i = 1; i < pushed.length; i++) {
            while (!stack.empty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
            stack.add(pushed[i]);
        }
        while (!stack.empty() && stack.peek() == popped[index]) {
            stack.pop();
            index++;
        }
        return stack.empty();
    }

    private boolean validateStackSequence2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }
}
