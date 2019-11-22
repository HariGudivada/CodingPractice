package LeetCode;

import java.util.ArrayList;
import java.util.List;

//#448
public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0 || nums[i] == i+1) {
                i++;
            } else if (nums[i] ==  nums[nums[i] - 1]) {
                nums[i] = 0;
                i++;
            }
            else {
                int index = nums[i] - 1;
                nums[i] = nums[index];
                nums[index] = index + 1;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,3,2,4,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

//        arr = new int[] { 2, 6, 4, 3, 1, 5 };
//        CyclicSort.sort(arr);
//        for (int num : arr)
//            System.out.print(num + " ");
//        System.out.println();
//
//        arr = new int[] { 1, 5, 6, 4, 3, 2 };
//        CyclicSort.sort(arr);
//        for (int num : arr)
//            System.out.print(num + " ");
//        System.out.println();
    }
}
