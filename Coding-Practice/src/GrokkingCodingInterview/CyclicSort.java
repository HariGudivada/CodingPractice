package GrokkingCodingInterview;

public class CyclicSort {
    public static void sort(int[] nums) {
        //Unique numbers
        // will be between 1 and n (inclusive)
        int i = 0;
        while (i < nums.length) {
            int j = nums[i]-1;
            if (i != j) {
                int temp = nums[j];
                nums[j] = j+1;
                nums[i] = temp;
            }

            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
