package LeetCode;
//https://leetcode.com/problems/longest-increasing-subsequence/ -300
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int[] count = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            count[i] = 1;
        }
        int max = 1;
        for (int j  = 0; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i]) {
                    count[j] = Math.max(count[i] + 1, count[j]);
                    if (count[j] > max) {
                        max = count[j];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        lis.lengthOfLIS(arr);
    }
}
