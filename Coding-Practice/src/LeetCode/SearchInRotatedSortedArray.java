package LeetCode;

import java.util.function.ObjIntConsumer;

/**
 * 33- https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public  static int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int dividing = findDividingPoint(nums, 0, nums.length-1);
        return search(nums, target, 0, nums.length-1, dividing);
    }
    public static int search(int[] nums, int target, int left, int right, int dividing) {

        if (nums[dividing] == target)
            return dividing;
        if ( dividing == 0) {
            return binarySearch(nums, left, right, target);
        }

        if ( target < nums[0]) {
            return binarySearch(nums, dividing, right, target);
        }
        return binarySearch(nums, left, dividing-1, target);

    }

    public static int binarySearch(int[]nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }

        return -1;
    }



    public static int findDividingPoint(int[] nums, int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }
        while (left <= right) {
            int mid = (left + right)/2;

            if (mid+1 < nums.length && nums[mid] > nums[mid+1]) {
                return mid+1;
            }

            if (nums[mid] < nums[left]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {8,9,2,3,4};
        search(arr, 0);
    }
}
