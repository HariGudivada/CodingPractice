package GrokkingCodingInterview;

import java.util.ArrayList;
import java.util.List;

public class FindCorruptNums {
    public static int[] findNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == nums[nums[i]-1]) {
                list.add(nums[i]);
            }
            i++;
        }
        return new int[] { -1, -1 };
    }
}
