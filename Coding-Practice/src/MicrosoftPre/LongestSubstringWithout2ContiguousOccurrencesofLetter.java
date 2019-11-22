package MicrosoftPre;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/discuss/interview-question/398031/
 */
public class LongestSubstringWithout2ContiguousOccurrencesofLetter {
    public String LongestSubString(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String result = "";
        int maxLength = Integer.MIN_VALUE;
//        Set<Character> set = new HashSet<>();
        int start = 0;
        int end ;
        char currChar = input.charAt(start);
        int count = 0;
        for (end = 0 ; end < input.length();end++) {
//            set.add(input.charAt(end));
            if (currChar  == input.charAt(end)) {
                count++;
                if (count > 2) {
                    maxLength = end -start > maxLength ? end-start : maxLength;
                    if (maxLength > result.length()) {
                        result = input.substring(start, end);
                        maxLength = result.length();
                    }
                    start = end-1;
                    end = end-1;
                    count =1;
                }
            }  else {
                currChar = input.charAt(end);
                count = 1;
            }

        }
        // we have check after the loop because the input can be at the end of the string.
        if (maxLength < end - start+1) {
            result = input.substring(start, end);
        }
        result = result.isEmpty() ? input.substring(start,end) : result;
        return  result;
    }

    public static void main(String[] args) {
        String s = "aabbaaaabababababbbbabababbababbbbbbbababababababababababababa";
        LongestSubstringWithout2ContiguousOccurrencesofLetter lc = new LongestSubstringWithout2ContiguousOccurrencesofLetter();
        String s1 = lc.LongestSubString(s);
    }
}
