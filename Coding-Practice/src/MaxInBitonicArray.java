public class MaxInBitonicArray {
    //https://hackernoon.com/the-ultimate-strategy-to-preparing-for-the-coding-interview-yxts3zbg

    public static int findMax(int[] array) {
        int start = 0;
        int end = array.length-1;

        while (start < end) {
            int middle = start + (end - start) /2 ;
            if (array[middle] > array[middle + 1]) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return array[start];
    }

    public static void main(String[] args) {
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
    }
}
