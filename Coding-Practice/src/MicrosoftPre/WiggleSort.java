package MicrosoftPre;

import java.util.Arrays;

public class WiggleSort {
    public static void wiggleSort(int[] nums) {
        int[] output = new int[nums.length];
        int[] copy = nums;
        Arrays.sort(copy);
        int i =0;
        int j = copy.length-1;
        int k =0;
        boolean low = true;
        while (i < j) {
            if (low) {
                output[k] = copy[i];
                low = false;
                i++;
            } else {
                output[k] = copy[j];
                low = true;
                j--;
            }
            k++;
        }
        for (i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] colors = {2,0,2,1,1,0};
        wiggleSort(colors);

    }
}
