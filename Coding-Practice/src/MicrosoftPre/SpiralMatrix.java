package MicrosoftPre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int rowStart = 0;
        int columnStart = 0;
        int rowEnd = matrix.length-1;
        int columnEnd = matrix[0].length-1;
        while (rowStart < rowEnd && columnStart < columnEnd) {
            int i = rowStart;
            int j = columnStart;
            while (j <= columnEnd) {
                result.add(matrix[i][j]);
                j++;
            }
            j = columnEnd;
            rowStart++;
            i = rowStart;
            while (i <= rowEnd) {
                result.add(matrix[i][j]);
                i++;
            }
            i = rowEnd;
            columnEnd--;
            j = columnEnd;
            while (j >= columnStart) {
                result.add(matrix[i][j]);
                j--;
            }
            j = columnStart;
            rowEnd--;
            i = rowEnd;
            while (i >= rowStart) {
                result.add(matrix[i][j]);
                i--;
            }
            i = rowStart;
            columnStart++;
            j = columnStart;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix sp = new SpiralMatrix();
        sp.spiralOrder(matrix);
    }
}
