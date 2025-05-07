import java.util.*;

public class Stack_The_Celebrity_Problem {
    public static int celebrityProblem(int mat[][]) {
        int n = mat.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (knows(mat, j, i)) {
                j = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (j != i && (knows(mat, j, i)) || !knows(mat, i, j)) {
                return -1;
            }
        }
        return j;
    }

    public static boolean knows(int mat[][], int i, int j) {
        return mat[i][j] == 1;
    }

    public static int celebrityProblemI(int mat[][]) {
        int n = mat.length;
        int celebrity = 0;
        int i = 1;
        while (i < n) {
            if (mat[celebrity][i] == 1) {
                celebrity = i;
            }
            i++;

        }
        for (int j = 0; j < n; j++) {
            if (j != celebrity) {

                if (mat[celebrity][j] == 1 || mat[j][celebrity] == 0) {
                    return -1;
                }
            }
        }
        return celebrity;
    }

    public static int celebrityProblemStack(int mat[][]) {
        int n = mat.length;
        Stack<Integer> st = new Stack<>(); 
        for (int i = 0; i < n; i++) {
            st.push(i  );
        }
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (mat[a][b] == 1) {
                st.push(b);
            } else {
                st.push(a);
            }
        }
        int candidate = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 } };
        int result = celebrityProblem(mat);
        int result1 = celebrityProblemI(mat);
        int result2 = celebrityProblemStack(mat);

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);

    }
}
