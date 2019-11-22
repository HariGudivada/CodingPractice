package GrokkingCodingInterview;

import java.util.ArrayList;
import java.util.List;

class SubsetsWithDuplicates {

    public static List<List<Integer>> findSubsetsWithoutDuplicates(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0; int endIndex = 0;
        for (int j = 0; j < nums.length; j++) {
            startIndex =0;
            if (j > 0 && nums[j] == nums[j-1]) {
                startIndex = endIndex+1;
            }
            endIndex = subsets.size()-1;
            for (int i = startIndex; i <= endIndex; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(nums[j]);
                subsets.add(set);
            }
        }

        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetsWithDuplicates.findSubsetsWithoutDuplicates(new int[] { 1, 3, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetsWithDuplicates.findSubsetsWithoutDuplicates(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}

