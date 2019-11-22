package GrokkingCodingInterview;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] result = new int[arr.length];
        int highestValueIndex = arr.length-1;
        int left = 0; int right = highestValueIndex;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                result[highestValueIndex] =  leftSquare;
                left++;
            } else {
                result[highestValueIndex] = rightSquare;
                right--;
            }
            highestValueIndex--;
        }

        return result;
    }
}
