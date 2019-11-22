package LeetCode;

/**
 * 34 problem number.
 */
public class SearchRange {
//    public static int[] searchRange(int[] nums, int target) {
//        if (nums.length < 1) {
//            return new int[]{-1,-1};
//        }
//        int start = 0;
//        int end = nums.length-1;
//        int mid = start +(end-start)/2;
//        int res1 = -1;
//        int res2 = -1;
//        if (nums[mid] ==  target) {
//            res1 = mid;
//            res1 = mid
//        }
//        return new int[6];
//    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (nums.length == 0 || low < 0 || high > nums.length - 1) {
            return -1;
        }
        if (low == high) {
            return nums[low] == target ? low : -1;
        }
        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, high, target);
        }
        return binarySearch(nums, low, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int i = binarySearch(arr, 0, arr.length - 1, 8);
        int j = i;
    }
}
