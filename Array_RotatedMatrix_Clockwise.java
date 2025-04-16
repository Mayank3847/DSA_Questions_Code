public class Array_RotatedMatrix_Clockwise {
    public static int[][] rotatedByBruteForce(int matrix[][]) {
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
        return rotated;
    }

    // By Optimal Solution ----->

    public static int[][] rotatedByOptimal(int matrix[][]) {
        int n = matrix.length;
        // int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        return matrix;
    }

    public static void printMatrix(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        int[][] matrixCopy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixCopy[i][j] = matrix[i][j];
            }
        }
        // Rotating using brute-force method
        int[][] rotatedMatrixBruteForce = rotatedByBruteForce(matrix);
        System.out.println("Rotated Matrix (90 degrees clockwise, Brute Force):");
        printMatrix(rotatedMatrixBruteForce);


        // Rotating using the optimal solution
        int[][] rotatedMatrixOptimal = rotatedByOptimal(matrixCopy);
        System.out.println("Rotated Matrix (90 degrees clockwise, Optimal Solution):");
        printMatrix(rotatedMatrixOptimal);
    }
}