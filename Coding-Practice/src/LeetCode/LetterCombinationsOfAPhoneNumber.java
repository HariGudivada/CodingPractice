package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 17
 */
public class LetterCombinationsOfAPhoneNumber {
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<List<String>> subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());
        char[] num = digits.toCharArray();
        for (char c : num) {
            int n = subSets.size();
            String letters = map.get(Character.toString(c));
            for (int j = 0; j < n ; j++) {
                for (int i = 0; i < letters.length(); i++){
                    List<String> set = new ArrayList<>(subSets.get(j));
                    set.add(Character.toString(letters.charAt(i)));
                    subSets.add(set);
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (List<String> set : subSets) {
            if (set.size() == digits.length()) {
                String temp ="";
                for (int i =0; i<set.size(); i++) {
                    temp += set.get(i);
                }
                result.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String num = "235";
        LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
        List<String> strings = lc.letterCombinations(num);
        System.out.println(strings);
    }
}
