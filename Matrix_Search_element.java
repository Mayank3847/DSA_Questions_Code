import java.util.Scanner;

public class Matrix_Search_element {
    public static boolean search_element_matrix(int matrix[][], int key, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == key) {
                    System.out.println(key + "found at cell(" + i + "," + j + ")");
                    return true;

                }
            }
        }
        System.out.println("KEY NOT FOUND");
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
        search_element_matrix(matrix, key, n, m);
        System.out.println("Smallest element: " + smallest);
        System.out.println("Largest element: " + largest);

        sc.close();

    }
}
