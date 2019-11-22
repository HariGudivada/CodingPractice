package LeetCode;

import java.util.*;

public class DineshAmcat {
    public int numIslands(List<List<Character>> grid) {
        if (grid.size() == 0) {
            return 0;
        }

        int count = 0;
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.size(); i++) {
            List<Character> subGrid = grid.get(i);
            int gridSize = subGrid.size();
            for (int j = 0; j < gridSize; j++) {
                if (subGrid.get(j) == '1') {
                    count++;
                    queue.add(Arrays.asList(i, j));
                }

                while (!queue.isEmpty()) {
                    List<Integer> list = queue.poll();
                    int x = list.get(0);
                    int y = list.get(1);
                    List<Character> sub = grid.get(x);
                    sub.set(y, '0');
                    grid.set(x, sub);
                    if (checkBoundaries(x+1, y, grid)) {
                        queue.add (Arrays.asList(x+1, y));
                    }

                    if (checkBoundaries(x-1, y, grid)) {
                        queue.add (Arrays.asList(x-1, y));
                    }

                    if (checkBoundaries(x, y-1, grid)) {
                        queue.add (Arrays.asList(x, y-1));
                    }

                    if (checkBoundaries(x, y+1, grid)) {
                        queue.add (Arrays.asList(x, y+1));
                    }
                }
            }
        }
        return count;
    }
    private boolean checkBoundaries(int i, int j, List<List<Character>> grid) {
        return i >= 0 && j >= 0 && i < grid.size() && j < grid.get(i).size() && grid.get(i).get(j) == '1';
    }

    private boolean checkBoundaries(int i, int j, int[][] grid) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == 0) {
            grid[i][j] = 1;
            return true;
        }
        return false;
    }

    /**
     * https://leetcode.com/discuss/interview-question/411357/
     */
    public int daysToConvertHumansToZombies(int[][] grid) {
        int days = 0;
        int count = 0;
        int target = grid.length * grid[0].length;
        if (grid == null || grid.length == 0) {
            return 0;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0 ; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    queue.add(Arrays.asList(i, j, days+1));
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (count == target) {
                return days;
            }

            for (int i = 0 ; i < size;i++) {
                List<Integer> list = queue.poll();
                if(checkBoundaries(list.get(0)+1, list.get(1), grid)) {
                    count++;
                    queue.add(Arrays.asList(list.get(0)+1, list.get(1)));
                }
                if (checkBoundaries(list.get(0)-1, list.get(1), grid)) {
                    count++;
                    queue.add(Arrays.asList(list.get(0)-1, list.get(1)));
                }
                if (checkBoundaries(list.get(0), list.get(1)-1, grid)) {
                    count++;
                    queue.add(Arrays.asList(list.get(0), list.get(1)-1));
                }
                if(checkBoundaries(list.get(0), list.get(1)+1, grid)) {
                    count++;
                    queue.add(Arrays.asList(list.get(0), list.get(1)+1));
                }
            }
            days++;
        }

        return -1;
    }

    public static void main(String[] args) {
        List<List<Character>> list = new ArrayList<>();
        list.add(Arrays.asList('1', '1', '0', '0','0'));
        list.add(Arrays.asList('1', '1', '0', '0','0'));
        list.add(Arrays.asList('0', '0', '1', '0','0'));
        list.add(Arrays.asList('0', '0', '0', '1','1'));

        int[][] grid = {{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};


        DineshAmcat dineshAmcat = new DineshAmcat();
        int i = dineshAmcat.numIslands(list);
        int days = dineshAmcat.daysToConvertHumansToZombies(grid);
        System.out.println(days);
    }
}
