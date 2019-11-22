package MicrosoftPre;
//419
//There is a better approch that this dfs. check submission on Leet code.
public class BattleShipsInABoard {
    int[][] dirs = {{0,1}, {0,-1},{1,0}, {-1,0}};
    char[][] board;
    public int countBattleships(char[][] board) {
        this.board = board;
        if (board.length == 0) {
            return -1;
        }
        int count = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 'X') {
                   sinkShips(r, c);
                   count++;
                }
            }
        }

        return count;
    }

    private void sinkShips(int r, int c){
        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length|| board[r][c] == '.') {
            return;
        }
        board[r][c] = '.';
        for (int[] dir : dirs) {
            sinkShips(dir[0]+r, dir[1]+c);
        }
    }
}
