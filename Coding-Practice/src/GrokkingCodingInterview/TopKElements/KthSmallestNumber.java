package GrokkingCodingInterview.TopKElements;

import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static int findKthSmallestNumber(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) {
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        for (int i = 0 ; i < k ; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }

    public static int findKthSmallestUsingQuickSelect(int[] nums, int k) {
        if (nums.length == 0) {
            return -1;
        }

        if (k > nums.length) {
            return -1;
        }
        quickSelect(0, nums.length-1, nums.length-k);

        return nums[nums.length-k];
    }

    private static void quickSelect(int i, int i1, int i2) {
        //https://www.youtube.com/watch?v=hGK_5n81drs
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
