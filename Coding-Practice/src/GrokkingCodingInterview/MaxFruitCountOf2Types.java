package GrokkingCodingInterview;

import java.util.HashMap;
import java.util.Map;

class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int basketCount = 2;
        if (arr.length <= 2) {
            return arr.length;
        }

        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();

        for (int end = 0; end < arr.length; end++) {
            fruitFrequencyMap.put(arr[end], fruitFrequencyMap.getOrDefault(arr[end], 0) + 1);
            while (fruitFrequencyMap.size() > basketCount) {
                fruitFrequencyMap.put(arr[start], fruitFrequencyMap.get(arr[start]) - 1);
                if (fruitFrequencyMap.get(arr[start]) == 0) {
                    fruitFrequencyMap.remove(arr[start]);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return -1;
    }
}
