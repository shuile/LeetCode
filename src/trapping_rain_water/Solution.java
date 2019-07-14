package trapping_rain_water;

public class Solution {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int index = -1;
        int trap = 0;
        for (int i = 0; i < height.length; i++) {
            if (index == -1) {
                if (height[i] != 0) {
                    index = i;
                }
                continue;
            }
            if (i == (height.length - 1) && index < (height.length - 1) && height[index] > height[i]) {
                i = index;
                index++;
                continue;
            }
            if (height[i] >= height[index]) {
                int top = height[index];
                for (int j = index + 1; j < i; j++) {
                    trap += top - height[j];
                }
                index = i;
            }
        }
        return trap;
    }
}
