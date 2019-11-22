package MicrosoftPre;
//https://leetcode.com/problems/island-perimeter/ - 463
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        for (int row = 0 ; row < grid.length ; row++) {
            for (int column  = 0; column < grid[0].length; column++) {
                //Yeah this is my island.
                if (grid[row][column] == 1) {
                    return findPerimeter(grid, row, column);
                }
            }
        }

        return 0;
    }

    private int findPerimeter(int[][] grid, int row, int column) {
        if(row < 0 || column < 0 || row > grid.length || column > grid[0].length){
            return 1;
        }

        if (grid[row][column] == -1) {
            return 1;
        }

        int count = 0;
        grid[row][column] = -1;
        count += findPerimeter(grid, row-1, column);
        count += findPerimeter(grid, row+1, column);
        count += findPerimeter(grid, row, column-1);
        count += findPerimeter(grid, row, column+1);

        return count;
    }
}
