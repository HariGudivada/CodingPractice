package GrokkingCodingInterview;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int target) {
        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i +1;
            int right = arr.length - 1;
            while (left < right) {
                int difference = target - arr[i] - arr[left] - arr[right];
                if (difference == 0) {
                    return target - difference;
                }

                if (Math.abs(difference) < Math.abs(smallestDifference)) {
                    smallestDifference = difference;
                }

                if (difference>0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return target - smallestDifference;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 0,1,2,3,4,5,6 }, 4));
    }
}
