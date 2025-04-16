import java.util.Queue;
import java.util.LinkedList;

public class Graph_RottenOrange {
    static class Orange {
        int x, y;

        Orange(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    public static int rottingOrange(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int rows = grid.length;
        int col = grid[0].length;
        Queue<Orange> qu = new LinkedList<>();
        int freshCnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    qu.add(new Orange(i, j));

                } else if (grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }
        if (freshCnt == 0) {
            return 0;

        }
        int time = 0;
        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!qu.isEmpty()) {
            int size = qu.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                Orange curr = qu.poll();
                for (int d = 0; d < direction.length; d++) {
                    int newX = curr.x + direction[d][0];
                    int newY = curr.y + direction[d][1];
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < col && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        qu.add(new Orange(newX, newY));
                        freshCnt--;
                        rotted = true;

                    }
                }
            }
            if(rotted){
                time++;
            }
        }
        if (freshCnt == 0) {
            return time;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        int result = rottingOrange(grid);
        System.out.println("Minimum time required to rot all oranges: " + result);
    }
}
