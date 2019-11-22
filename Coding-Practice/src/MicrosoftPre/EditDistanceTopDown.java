package MicrosoftPre;

public class EditDistanceTopDown {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0)  {
            return m+n;
        }

        int[][] matrix = new int[m+1][n+1];
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = i;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    matrix[i][j] = matrix[i-1][j-1];
                } else {
                    matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));
                }
            }
        }

        return matrix[m-1][n-1];
    }
}
