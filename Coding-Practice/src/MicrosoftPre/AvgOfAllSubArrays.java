package MicrosoftPre;

import java.util.HashMap;
import java.util.Map;

public class AvgOfAllSubArrays {
    //https://www.educative.io/collection/page/5668639101419520/5671464854355968/6658855733821440
    public double[] getAvg (int k, int[] array) {
        double[] result = new double[array.length-k+1];
        for (int i = 0 ; i <= array.length-k ; i++) {
            double sum = 0;
            for (int j = i; j < i+k ; j++) {
                sum += array[j];
            }

            result[i] = sum/k;
        }

        return result;
    }
    public double[] getAvgBackTrackingApproach (int k , int[] array) {
        double[] result = new double[array.length];
        int windowStart = 0;
        double sum = 0;
        for (int windowEnd = 0; windowEnd > array.length; windowEnd ++) {
            sum += array[windowEnd];
            if (windowEnd >= k-1) {
                result[windowStart] = sum /k ;
                sum -= array[windowStart];
                windowStart++;
            }
        }

        return result;
    }

    public int maxSumSubArray(int k, int[] array) {
        int windowStart = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for ( int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            sum += array[windowEnd];

            if (windowEnd >= k -1) {
                max = Math.max(max, sum);
                sum -= array[windowStart];
                windowStart++;
            }
        }

        return max;
    }

    //https://www.educative.io/collection/page/5668639101419520/5671464854355968/4578892830474240
    public int minimumSubArray(int k, int[] array) {
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for ( int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            sum += array[windowEnd];

            while (sum >= k) {
                minLength = Math.min(minLength, windowEnd-windowStart +1);
                sum -= array[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public int getLengthOfLongestSubString(int numOfDistinctChar, String string) {

        if (string == null || string.isEmpty() || string.length() < numOfDistinctChar) {
            throw new IllegalArgumentException("Valid arguments should be passed.");
        }

        int maxLength = 0;
        int windowStart = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char rightChar = string.charAt(windowEnd);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) +1);

            while (charMap.size() > numOfDistinctChar) {
                char leftChar = string.charAt(windowStart);

                charMap.put(leftChar, charMap.get(leftChar)-1);

                if (charMap.get(leftChar) <=0){
                    charMap.remove(leftChar);
                }

                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart +1);
        }

        return maxLength;
    }
}
