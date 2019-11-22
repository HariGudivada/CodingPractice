package MicrosoftPre;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        return searchInSortedArray(nums, target);
    }

    public int searchInSortedArray(int[] nums, int target) {
        int partitionPoint = partitionPoint(nums);
        if (nums[partitionPoint] == target) {
            return partitionPoint;
        }

        if(partitionPoint == 0) {
            return binarySearch(nums, 0, nums.length-1, target);
        }

        if (target < nums[0]) {
            return binarySearch(nums, partitionPoint, nums.length-1, target);

        }
        return binarySearch(nums, 0, partitionPoint-1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }

        return -1;
    }

    private int partitionPoint(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right]) {
            return 0;
        }
        while(left <= right) {
            int mid = (left + right)/2;
            if(mid+1 < nums.length && nums[mid] > nums[mid+1]) {
                return mid+1;
            } else if (nums[mid] < nums[left]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,2};
        int target = 2;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        searchInRotatedSortedArray.search(arr, target);
    }
}
