package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 422
 */
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0 ; j < words.get(i).length(); j++) {
                if( j >=words.size() || words.get(j).length() <= i|| words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList("abc", "a"));
        ValidWordSquare validWordSquare = new ValidWordSquare();
        System.out.println(validWordSquare.validWordSquare(strings));
    }
}
