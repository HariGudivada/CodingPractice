package LeetCode;

/**
 * 11
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int l  = 0;
        int r = height.length-1;
        int maxArea = 0;
        while (l < r && r < height.length) {
            int length = r -l;
            int minHeight = Math.min (height[r], height[l]);
            int area = length * minHeight;
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[]height = {2,3,4,5,18,17,6};
        int i = maxArea(height);
        int k = i;
    }
}
