package GrokkingCodingInterview;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {
    public static int findNumber(int[] nums) {
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    list.add(nums[i]);
                }
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
