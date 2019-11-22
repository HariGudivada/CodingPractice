package MicrosoftPre;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class TrappingRainWater {
    int [] arr;
    public int trap(int[] height) {

        if (height.length < 2) {
            return 0;
        }
        arr = height;
        int sum =0;

        for (int i = 1; i < height.length;i++) {
            int left = i-1;
            int leftHeight = 0;
            while(left >= 0) {
                if(height[left] > height[i]) {
                    leftHeight = height[left];
                    break;
                }
                left--;
            }
            int right = i+1;
            int rightHeight =0 ;
            while (right < height.length) {
                if(height[right] > height[i]) {
                    rightHeight = height[right];
                    break;
                }
                right++;
            }
            int minHeight = Math.min(leftHeight, rightHeight);
            sum += height[i] - minHeight;
        }

        return sum;
    }

    private int findMaxHeight(int left, int right) {

        if (left < 0 || right >arr.length-1) {
            return 0;
        }
        if (left == right) {
            return arr[left];
        }

        int max = 0;
        for (int i = left ; i <= right; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        TrappingRainWater tp =new TrappingRainWater();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        tp.trap(arr);

    }


}
