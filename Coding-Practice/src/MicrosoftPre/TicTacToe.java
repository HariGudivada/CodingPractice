package MicrosoftPre;

import java.util.HashSet;
import java.util.Set;

class TicTacToe {
    int[][] grid;
    int val;
    boolean change = false;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.grid = new int[n][n];
        this.val = 1;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (change) {
            grid[row][col] = -1;
        } else {
            grid[row][col] = 1;
        }

        boolean gameDone = checkAllCases(grid[row][col], row, col);
        change = !change;
        if (gameDone) {
            if (!change) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    private boolean checkAllCases(int val, int row, int col) {
        return checkHorizontal(val, row, col) ||
        checkVertical(val, row, col) ||
        checkDiagonal(val, row, col);

    }

    private boolean checkDiagonal(int val, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] != val) {
                return false;
            }
        }
        int i = 0;
        int j = grid[row].length;
        while (i < grid.length) {
            if(grid[i][j] != val) {
                return false;
            }
        }
        return true;
    }

    private boolean checkVertical(int val, int row, int col) {
        int tempRow = row-1;
        while (tempRow >=0) {
            if (grid[tempRow][col] != val) {
                return false;
            }
            tempRow--;
        }
        tempRow = row+1;
        while (tempRow < grid.length) {
            if (grid[tempRow][col] != val) {
                return false;
            }
            tempRow++;
        }
        return true;
    }

    private boolean checkHorizontal(int val, int row, int col) {
        int tempCol = col-1;
        while (tempCol >=0) {
            if (grid[row][tempCol] != val) {
                return false;
            }
            tempCol--;
        }
        tempCol = col+1;
        while (tempCol < grid[row].length) {
            if (grid[row][tempCol] != val) {
                return false;
            }
            tempCol++;
        }
        return true;
    }

    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
        set.add(new int[] {2,3});
        System.out.println(set.contains(new int[]{2,3}));

    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
