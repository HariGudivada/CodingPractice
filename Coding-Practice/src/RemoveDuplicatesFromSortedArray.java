public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        int i = 0;
        int j = 1;

        while (j<nums.length) {

            if (nums[i] == nums[j] || nums[i] < nums[j]) {
                if(nums[i] == nums[j]) {
                    while (j < nums.length && nums[i] == nums[j]) {
                        j++;
                    }
                }
                if (j >= nums.length ) return count+1;
                if (nums[i+1] != nums[j]) {
                    int temp = nums[i+1];
                    nums [i+1] = nums [j];
                    nums[j] =  temp;

                }

                i++;
                j++;
                count ++;

            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        int[]  input = {1,2,3,6,7,78};
        System.out.println(removeDuplicates(input));
    }
}
