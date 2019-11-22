package LeetCode;

public class LongestPalindromicSubSequence {
    public static int longestPalindromicSubSequence(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[][] matrix = new int[s.length()][s.length()];
        for (int i =0; i < s.length(); i++) {
            matrix[i][i] = 1;
        }
        int window = 2, j = 0;
        for (window = 2; window <= s.length(); window++) {
            for (int i = 0; i < s.length()-window+1; i++) {
                j = i + window-1;
                if (s.charAt(i) == s.charAt(j) && window == 2) {
                    matrix[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = matrix[i+1][j-1]+2;
                } else {
                    matrix[i][j] = Math.max(matrix[i][j-1], matrix[i+1][j]);
                }
            }
        }
        return matrix[0][s.length()-1];
    }

    public static void main(String[] args) {
        String string = "daaacd";
        System.out.println(longestPalindromicSubSequence(string));
    }
}
