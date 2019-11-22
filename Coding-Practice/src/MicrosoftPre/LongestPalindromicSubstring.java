package MicrosoftPre;

import LeetCode.LongestIncreasingSubsequence;

//5
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (s.length() == 1) {
            return s;
        }

        int i = 0;
        int j = s.length() - 1;
        String result = "";

        while (i <= j) {
            if (isPalindrome(s, i, j) && result.length() < s.substring(i, j + 1).length()) {
                result = s.substring(i, j + 1);
            }
            i++;
            j--;
        }
        i = 0;
        j = s.length() - 1;
        while (i < j) {
            if (isPalindrome(s, i, j) && result.length() < s.substring(i, j + 1).length()) {
                result = s.substring(i, j + 1);
            }
            j--;
        }
        i = 0;
        j = s.length() - 1;
        while (i <= j) {
            if (isPalindrome(s, i, j) && result.length() < s.substring(i, j + 1).length()) {
                result = s.substring(i, j + 1);
            }
            i++;
        }


        return result;

//         int[][] matrix = new int[s.length()][s.length()];

//         for (int i =0; i < s.length(); i++) {
//             matrix[i][i] = 1;
//         }

//         int window = 2, j = 0;
//         for (window = 2; window < s.length(); window++) {
//             for (int i = 0; i < s.length()-window; i++) {
//                 j = i + window-1;
//                 if (s.charAt(i) == s.charAt(j)) {
//                     matrix[i][j] = matrix[i+1][j-1]+2;
//                 } else {
//                     matrix[i][j] = Math.max(matrix[i][j-1], matrix[i+1][j]);
//                 }
//             }
//         }

//         return matrix[0][s.length()-1];
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (s == null || s.length() < 2) {
            return true;
        }
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        longestPalindromicSubstring.longestPalindrome("babd");

    }
}
