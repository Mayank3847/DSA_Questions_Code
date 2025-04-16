import java.util.*;

public class Recurssion_BackTracking_Rat_In_Maze {
    public static void solve(int mat[][], int i, int j, int n, ArrayList<String> ans, String result, int[][] visited) {
        if (i == n - 1 && j == n - 1) {
            ans.add(result);
            return;
        }
            visited[i][j] = 1;

        // Downward
        if (i + 1 < n && visited[i + 1][j] == 0 && mat[i + 1][j] == 1) {
            solve(mat, i + 1, j, n, ans, result+"D", visited);
        }


         // Left
         if (j - 1 >= 0 && visited[i][j - 1] == 0 && mat[i][j - 1] == 1) {
            solve(mat, i, j - 1, n, ans, result+"L", visited);

        }

        // Right
        if (j + 1 < n && visited[i][j + 1] == 0 && mat[i][j + 1] == 1) {
            solve(mat, i, j + 1, n, ans, result+"R", visited);

        }

        

        // Upward
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && mat[i - 1][j] == 1) {
            solve(mat, i - 1, j, n, ans, result+"U", visited);

        }
        visited[i][j] = 0;

    }

    public static ArrayList<String> ratInMaze(int[][] maze, int n) {
        int visited[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        if (maze[0][0] == 1) {
            solve(maze, 0, 0, n, ans, "", visited);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1 , 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        System.out.println("Input Maze:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<String> paths = ratInMaze(maze, n);
        if (paths.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Paths found: " + paths);
        }
    }

}
