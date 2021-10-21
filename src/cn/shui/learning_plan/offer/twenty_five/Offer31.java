package cn.shui.learning_plan.offer.twenty_five;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/10/21.
 * @time 14:58.
 */
public class Offer31 {

    public static void main(String[] args) {
        Offer31 test = new Offer31();
        System.out.println(test.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
