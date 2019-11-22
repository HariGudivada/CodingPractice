package Misc;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInAMatrix {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
        System.out.println(minDays(grid));
    }

    private static int minDays(int[][] grid) {
        //Collect all the transmitting cells.
        Queue<int[]> q = new LinkedList<>();
        //
        int target = grid.length * grid[0].length;
        //
        int cnt = 0, res = 0;
        //Iterate the entire grid.
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                //Place all the transmitting points in the queue.
                if(grid[i][j] == 1) {
                    q.offer(new int[] {i,j});
                    cnt++;
                }
            }
        }
        //right, left, top, bottom.
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            //If the count is equal to the number of cells in the grid, the data has been transmitted to all the cells.
            if(cnt == target)
                return res;
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                //Check all the four directions.
                for(int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    //If we are within the grid and the cell we are visiting is not visited before.
                    if(ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == 0) {
                        cnt++;
                        q.offer(new int[] {ni, nj});
                        grid[ni][nj] = 1;
                    }
                }
            }
            res++;
        }
        //If we are not able to transmit the data to all the cellls in the grid, return -1.
        return -1;
    }
    //Time complexity:rows*columns. We check all the cells in the worst case.
}
