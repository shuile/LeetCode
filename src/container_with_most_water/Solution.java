package container_with_most_water;

public class Solution {
    public static void main(String[] args) {

    }

    private static int maxArea2(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    /**
     * 方法1
     * @param height
     * @return
     */
    private static int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                if (max < h * (j - i)) {
                    max  = h * (j - i);
                }
            }
        }
        return max;
    }
}
