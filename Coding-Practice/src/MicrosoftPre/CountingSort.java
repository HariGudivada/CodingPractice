package MicrosoftPre;

import java.util.Arrays;

public class CountingSort {
    public static void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int[] colorCount = new int[3];
        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            colorCount[nums[i]]++;
        }

        for (int i = 1; i < colorCount.length; i++) {
            colorCount[i] += colorCount[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            int color = nums[i];
            int index = colorCount[color];
            colorCount[color]--;
            output[index-1] = color;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] colors = {2,0,2,1,1,0};
        sortColors(colors);

    }
}
