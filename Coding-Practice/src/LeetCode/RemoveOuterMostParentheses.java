package LeetCode;

/**
 * 1021
 */
public class RemoveOuterMostParentheses {
    public static String removeOuterParentheses(String S) {
        int start = 0;
        int end = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (start <= end && end<S.length()){
            if (S.charAt(end) == '(') {
                count++;
            } else {
                count--;
            }

            end++;

            if (count == 0) {
                sb.append(S.substring(start+1, end-1));
                start = end;
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())";
        removeOuterParentheses(s);
    }
}
