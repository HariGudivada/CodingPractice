package GrokkingCodingInterview;

import java.util.HashMap;
import java.util.Map;

public class NoRepeateSubString {
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(str.charAt(windowEnd), windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }

    public static int findLengthh(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            if (charIndexMap.containsKey(str.charAt(end))) {
                start = Math.max(start, charIndexMap.get(start)+1);
            }
            charIndexMap.put(str.charAt(end), end);
            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        findLength("abccb");
    }
}
