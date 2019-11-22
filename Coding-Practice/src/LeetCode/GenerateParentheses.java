package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//22 - https://leetcode.com/problems/generate-parentheses/
//https://www.youtube.com/watch?v=sz1qaKt0KGQ
public class GenerateParentheses {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        backTrack(n, n, "");
        return result;
    }

    private void backTrack(int openCount, int closeCount, String stringInProgress) {
        if (openCount == 0 && closeCount == 0) {
            result.add(stringInProgress);
            return;
        }

        if (openCount > 0) {
            backTrack(openCount-1, closeCount, stringInProgress+"(");
        }

        if (openCount < closeCount) {
            backTrack(openCount, closeCount-1, stringInProgress+")");
        }
    }
}
