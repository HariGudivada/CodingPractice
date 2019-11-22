package LeetCode;

public class SearchInSortedMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            row++;
            if (target <= matrix[i][matrix[i].length-1]) {
                break;
            }
            if (i == matrix.length-1 && target > matrix[i][matrix[i].length]) {
                return false;
            }
        }

        if (row == matrix.length) {
            return false;
        }
        int i =0;
        int j = matrix[row].length;
        int[] rowArr = matrix[row];
        while (i < j) {
            int mid = (i+j)/2;
            if (rowArr[mid] == target) {
                return true;
            } else if (rowArr[mid] < target) {
                i = mid;
            } else {
                j = mid;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][]matrix = {
        {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        int target = 51;

        System.out.println(searchMatrix(matrix, target));
    }
}
