package GrokkingCodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int n = permutations.size();
            for (int k = 0; k < n; k++) {
                List<Integer> oldPermutation = permutations.poll();
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currNum);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.permute(new int[]{1, 3, 5});
        System.out.print("Here are all the permutations: " + result);
    }
}
