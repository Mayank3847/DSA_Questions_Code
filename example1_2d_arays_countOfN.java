import java.util.*;

public class example1_2d_arays_countOfN {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking input for the dimensions of the 2D array
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int columns = scanner.nextInt();

        // Declaring the 2D array
        int[][] array = new int[rows][columns];

        // Taking input for each element of the 2D array
        System.out.println("Enter the elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("ENTER THE NUMBER OF WHICH THE COUNT IS TO FOUND :");
        int n = scanner.nextInt();

        // Displaying the 2D array
        System.out.println("The 2D array is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(); // Move to the next row
        }
        int countOf_n = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == n) {
                    countOf_n++;
                } else {
                    //System.out.print(n + "NOT FOUND!");
                }
            }
        }
        System.out.println("NO.OF THE " + n + "FOUND:" + countOf_n);

        scanner.close();
    }
}
