package GrokkingCodingInterview;

public class RemoveDuplicates {

    public static int remove(int[] arr) {
        int nextToDup = 1;
        for (int i = 1; i < arr.length; i++) {
            int i1 = arr[nextToDup - 1];
            int i2 = arr[i];
            if (i1 != i2) {
                arr[nextToDup] = i2;
                nextToDup++;
            }
        }

        return nextToDup;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
