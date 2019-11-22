package MicrosoftPre;

public class GameOfLife {
    int[][] board;
    public void gameOfLife(int[][] board) {
        this.board = board;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                nextState(r,c);
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == -1) {
                    board[r][c] = 1;
                } else if (board[r][c] == 2){
                    board[r][c] = 0;
                }
            }
        }
    }

    private void nextState(int r, int c) {
        int numOfN = 0;
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1},{1,1},{-1,-1},{1,-1},{-1,1}};
        for (int[] dir : dirs) {
            numOfN += checkNeighbour(r+dir[0], c+dir[1]);
        }
        if (board[r][c] == 1) {
            if (numOfN < 2 || numOfN > 3) {
                board[r][c] = -1;
            }
        } else {
            if (numOfN == 3) {
                board[r][c] = 2;
            }
        }
    }

    private int checkNeighbour(int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length) {
            return 0;
        }

        if (Math.abs(board[r][c]) == 1) {
            return 1;
        }
        return 0;
    }
}
