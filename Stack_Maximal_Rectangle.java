import java.util.*;

public class Stack_Maximal_Rectangle {
    public static int areaMaximalRectangle(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int maxArea = 0;
        int prefSum[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    prefSum[i][j] = 0;
                } else {
                    if (i == 0) {
                        prefSum[i][j] = 1;
                    } else {
                        prefSum[i][j] = prefSum[i - 1][j] + 1;
                    }
                }
            }
        }
        for (int k = 0; k < n; k++) {
            maxArea = Math.max(maxArea, largestHistogram(prefSum[k]));
        }
        return maxArea;
    }

    public static int largestHistogram(int arr[]) {
        int n = arr.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])) {
                int ht =arr[ st.peek()];
                st.pop();
                int wt;
                if (st.isEmpty()) {
                    wt = i;
                } else {
                    wt = i - st.peek() - 1;
                }
                maxArea = Math.max(maxArea, ht * wt);
            }
            st.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 1, 0, 0 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 0 }
        };
        int result = areaMaximalRectangle(matrix);
        System.out.println(result);

    }

}
  