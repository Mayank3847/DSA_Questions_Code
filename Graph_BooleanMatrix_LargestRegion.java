public class Graph_BooleanMatrix_LargestRegion {
    public static boolean isSafe(int matrix[][], boolean isVisit[][], int row, int col) {
        return (row >= 0 && row < matrix.length &&
                col >= 0 && col < matrix[0].length
                && matrix[row][col] == 1 && !isVisit[row][col]);
    }

    public static int dfs(int matrix[][], boolean isVisit[][], int row, int col){
        int rowDir[]={-1, -1, -1, 0, 0, 1, 1, 1};
        int colDir[]={-1, 0, 1, -1, 1, -1, 0, 1};
        isVisit[row][col]=true;
        int size=1;
        for(int i=0;i<8;i++){
            int newRow=row+rowDir[i];
            int newCol=col+colDir[i];
            if(isSafe(matrix, isVisit, newRow, newCol)){
                size+=dfs(matrix, isVisit, newRow, newCol);
            }

        }
        return size;
    }

    public static int largestRegion(int matrix[][]) {
        int maxRegionSize = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean isVisit[][] = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] ==1 && !isVisit[i][j]) {
                    int regionSize = dfs(matrix, isVisit, i, j);
                    maxRegionSize = Math.max(maxRegionSize, regionSize);

                }
            }
        }
        return maxRegionSize;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 1, 1, 0 },
                { 1, 1, 0, 0, 1 },
                { 0, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 0, 0, 0 }
        };
        System.out.println("Size of the largest region is: " + largestRegion(matrix));
    }

}
