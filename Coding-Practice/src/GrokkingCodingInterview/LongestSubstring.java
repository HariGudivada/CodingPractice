package GrokkingCodingInterview;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static int findLength(String str, int k) {
        if ( str.isEmpty() || str.isBlank() || k >= str.length()) {
            throw new IllegalStateException("wrong args");
        }

        int start =  0, maxLength = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            characterIntegerMap.put (rightChar, characterIntegerMap.getOrDefault(rightChar, 0)+1);
            while (characterIntegerMap.size() > k) {
                char leftChar =  str.charAt(start);
                characterIntegerMap.put(leftChar, characterIntegerMap.get(leftChar)-1);
                if (characterIntegerMap.get(leftChar) == 0) {
                    characterIntegerMap.remove(leftChar);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end -start+1);
        }

        return maxLength;
    }
}
