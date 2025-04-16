import java.util.*;

public class Search_in_Sorted_Matrix {
    public static boolean staircaseSearch(int matrix[][], int key, int n, int m) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("FOUND KEY AT (" + row + "," + col + ")");
                return true;

            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int n = sc.nextInt();
        System.out.println("Enter the number of columns:");
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();

            }
        }
        System.out.println("Enter the key to search:");
        int key = sc.nextInt(); // Reading the key to search
        int smallest = matrix[0][0]; // Initialize smallest with the first element
        int largest = matrix[0][0]; // Initialize largest with the first element

        // Finding smallest and largest elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < smallest) {
                    smallest = matrix[i][j];
                }
                if (matrix[i][j] > largest) {
                    largest = matrix[i][j];
                }
            }
        }
        // output
        System.out.println("Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        staircaseSearch(matrix, key, n, m);
        System.out.println("Smallest element: " + smallest);
        System.out.println("Largest element: " + largest);

        sc.close();

    }
}
