package MicrosoftPre;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetZeros {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) {
            return;
        }
        List<List<Integer>> points = new ArrayList<>();
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    List<Integer> list  = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    points.add(list);
                }
            }
        }

        for (List<Integer> list : points) {
            int i = list.get(0);
            int j = list.get(1);
            int row = i-1;
            while(row >= 0) {
                matrix[row][j] =  0;
                row--;
            }
            row = i+1;
            while(row < matrix.length) {
                matrix[row][j] =  0;
                row++;
            }
            int column = j-1;
            while(column >= 0) {
                matrix[i][column] =  0;
                column--;
            }
            column = j +1;
            while(column < matrix[0].length) {
                matrix[i][column] =  0;
                column++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1,1,1}, {1,0,1}, {1,1,1}};
        SetZeros setZeros = new SetZeros();
        setZeros.setZeroes(input);
    }
}
