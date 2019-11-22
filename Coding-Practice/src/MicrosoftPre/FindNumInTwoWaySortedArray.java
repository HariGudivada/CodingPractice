package MicrosoftPre;

public class FindNumInTwoWaySortedArray {
    public static int search(int[] nums, int target, int left, int right, int dividing) {
        int n = nums.length;

        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums[dividing] == target)
            return dividing;
        if ( dividing == 0) {
            return search(nums, target,left, right, dividing);
        }

        if ( target > nums[dividing]) {
            return search(nums, target,left, dividing-1, dividing);
        }
        return search(nums, target,dividing+1, right, dividing);

    }
    public static int findDividingPoint(int[] nums, int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }
      while (left <= right) {
          int mid = (left + right - left)/2;
          if ( nums[mid] > nums[mid+1]) {
              return mid+1;
          }
         if (nums[mid] > left){
             left = mid+1;
         }
         else {
             right = mid-1;
         }
      }

      return 0;
    }

    public static void main(String[] args) {
        int [] array  = {4,5,6,7,0,1,2};
        int target = 0;
//        System.out.println(search(array, target, 0, array.length-1));
    }
}
