import java.util.Arrays;

public class Array_SetMatrixZero {
    public void setMatrixZeroes(int[][] arr) {
        int rows = arr.length;
        int col = arr[0].length;
        boolean[] zeroRow = new boolean[rows];
        boolean[] zeroCol = new boolean[col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            if (zeroRow[i]) {
                Arrays.fill(arr[i], 0);

            }
        }
        for (int j = 0; j < col; j++) {
            if (zeroCol[j]) {
                for (int i = 0; i < rows; i++) {
                    arr[i][j] = 0;
                }
            }
        }
        return;
    }

    public static void setMatrixZeroOptimal(int arr[][]) {
        int rows = arr.length;
        int col = arr[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i < rows; i++) {

            if (arr[i][0] == 0) {
                firstRow = true;
                break;

            }
        }
        for(int i =1;i<rows;i++){
            for(int j =1;j<col;j++){
if(arr[i][j]==0)
{
    arr[i][0]=0;
    arr[0][j]=0;
}            
}
        }
        for(int i =1;i<rows;i++){
            for(int j =1;j<col;j++){
                if(arr[i][0]==0||arr[0][j]==0){

                    arr[i][j]=0;
                }


                }
            }
            if(firstRow){
                Arrays.fill(arr[0],0);
            }
            if(firstCol){
                for(int i =0;i<rows;i++){
                    arr[i][0]=0;                }
            }
        }

        public static void main(String[] args) {
            Array_SetMatrixZero solution = new Array_SetMatrixZero();
    
            // Example input matrix
            int[][] matrix1 = {
                    { 1, 1, 1 },
                    { 1, 0, 1 },
                    { 1, 1, 1 }
            };
    
            // Display original matrix
            System.out.println("Original Matrix:");
            for (int[] row : matrix1) {
                System.out.println(Arrays.toString(row));
            }
    
            // Call the basic method to set zeroes
            solution.setMatrixZeroes(matrix1);
    
            // Display the modified matrix using the basic method
            System.out.println("Modified Matrix (Basic):");
            for (int[] row : matrix1) {
                System.out.println(Arrays.toString(row));
            }
    
            // Example input matrix for optimal solution
            int[][] matrix2 = {
                    { 1, 1, 1 },
                    { 1, 0, 1 },
                    { 1, 1, 1 }
            };
    
            // Display original matrix for optimal solution
            System.out.println("\nOriginal Matrix for Optimal:");
            for (int[] row : matrix2) {
                System.out.println(Arrays.toString(row));
            }
    
            // Call the optimal method to set zeroes
            setMatrixZeroOptimal(matrix2);
    
            // Display the modified matrix using the optimal method
            System.out.println("Modified Matrix (Optimal):");
            for (int[] row : matrix2) {
                System.out.println(Arrays.toString(row));
            }
        }
}
