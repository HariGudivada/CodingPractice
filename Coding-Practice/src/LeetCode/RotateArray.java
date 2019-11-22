package LeetCode;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if (k == 0) {
            return ;
        }
        int[] result = new int[nums.length];
        for ( int i = 0 ; i< nums.length; i++) {
            int newIndex = (i+k)%nums.length;
            result[newIndex] = nums[i];
        }

        nums = result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(array, k);
    }

}
