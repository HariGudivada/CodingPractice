package GrokkingCodingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCaseStringPermutation {
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null) {
            return permutations;
        }
        permutations.add(str);
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)) ) {
                continue;
            }
            int n = permutations.size();
            for (int j = 0; j < n; j++) {
                String existingPerm = permutations.get(j);
                char[] chars = existingPerm.toCharArray();
                if (Character.isUpperCase(chars[i])) {
                    chars[i] = Character.toLowerCase(chars[i]);
                } else {
                    chars[i] = Character.toUpperCase(chars[i]);
                }
                String newPerm = String.valueOf(chars);
                permutations.add(newPerm);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
