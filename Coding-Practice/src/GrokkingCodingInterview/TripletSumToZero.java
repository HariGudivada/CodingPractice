package GrokkingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            // comparing the sum of two numbers to the 'targetSum' can cause integer overflow
            // so, we will try to find a target difference instead
            int targetDiff = targetSum - arr[left];
            if (targetDiff == arr[right]) { // found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--; // skip same element to avoid duplicate triplets
            } else if (targetDiff > arr[right])
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
    }

    public static List<List<Integer>> searchTrip(int[] arr) {
        //at least we should have 3 elements
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] ==  arr[i-1]) {
                continue;
            }
            searchPairs(arr, -arr[i], i+1, triplets);
        }

        return triplets;
    }

    private static void searchPairs(int[] arr, int target, int left, List<List<Integer>> triplets) {
        int right = arr.length-1;
        while (left  < right) {
            int difference = target - arr[left];
            if (difference == arr[right]) {
                triplets.add(Arrays.asList(-target, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left-1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right+1]) {
                    right--;
                }
            } else if (difference > arr[right]) {
                left++;
            } else {
                right++;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
    }
}
