
public class Matrix_Rotate_Each_Row_of_Matrix_K_Times {

    public static int[][] rotateMatrix(int k, int mat[][]) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        k = k % cols;  // Effective rotation
        
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][(j + cols - k) % cols] = mat[i][j];
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        int k = 2;
        
        int[][] rotatedMatrix = rotateMatrix(k, mat);
        
        // Print the rotated matrix
        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[0].length; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
