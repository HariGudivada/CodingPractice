package MicrosoftPre;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    int[][] maze;
    int[] start;
    int[] destination;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0) {
            return true;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] ==  destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x = x + dir[0];
                    y = y + dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    visited[x - dir[0]][y - dir[1]] = true;
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                }
            }
        }
        return false;
    }
}
