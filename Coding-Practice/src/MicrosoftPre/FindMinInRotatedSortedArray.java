package MicrosoftPre;

public class FindMinInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int middle = (left + right)/2;
            if (middle+1 < nums.length && nums[middle] > nums[middle+1]) {
                return nums[middle+1];
            } else if (nums[left] <= nums[middle]) {
                left = middle+1;
            } else {
                right = middle-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        System.out.println(findMin(arr));
    }
}
