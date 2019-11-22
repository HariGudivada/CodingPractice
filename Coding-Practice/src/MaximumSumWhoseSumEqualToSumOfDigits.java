import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumSumWhoseSumEqualToSumOfDigits {

    public static int requiredSum (int[] input) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : input){
            maxheap.add(i);
        }

        while (!maxheap.isEmpty()) {
            int max = maxheap.poll();
            int nextMax =  maxheap.peek();
            int sum = max + nextMax;
            int result = addDigits (max, nextMax);
            if (Integer.toString(sum).equals(Integer.toString(result))) {
                return sum;
            }
        }
        return -1;
    }

    private static int addDigits(final int max, final int nextMax) {
        char[] maxArray = Integer.toString(max).toCharArray();
        char[] nextMaxArray = Integer.toString(nextMax).toCharArray();

        int i = 0;
        String sumString = "";
        while (i < maxArray.length || i < nextMaxArray.length) {
            int digit = 0;
            int digit2 = 0;
            if (i < maxArray.length) {
                digit = Character.getNumericValue(maxArray[i]);
            }
            if (i < nextMaxArray.length) {
                digit2 = Character.getNumericValue(nextMaxArray[i]);
            }

            int sum = digit + digit2;

            sumString += sum;
            i++;
        }

        return Integer.parseInt(sumString);
    }

    public static void main(String[] args) {
        System.out.println(requiredSum(new int[]{51,32, 43}));
    }
}
