public class BinarySearch_PeakElement_2D_Array {
    public static int[] findPeakElem(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int current = arr[i][j];
                boolean isTopSmaller = (i == 0) || current >= arr[i - 1][j];
                boolean isLeftSmaller = (j == 0) || current >= arr[i][j - 1];
                boolean isRightSmaller = (j == m - 1) || current >= arr[i][j + 1];
                boolean isBottomSmaller = (i == n - 1) || current >= arr[i + 1][j];
                if (isBottomSmaller && isTopSmaller && isLeftSmaller && isRightSmaller) {
                    return new int[] { i, j };
                }

            }
        }
        return new int[] { -1, -1 };
    }

    public static int findMaxIndex(int mat[][], int n, int m, int col) {
        int maxValue = -1, index = -1;
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    public static int[] findPeakElemOptimized(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxRow = findMaxIndex(mat, n, m, mid);
            int left, right;
            if (mid + 1 < m) {
                right = mat[maxRow][mid + 1];
            } else {
                right = -1;
            }
            if (mid - 1 >= 0) {
                left = mat[maxRow][mid - 1];

            } else {
                left = -1;
            }
            if (mat[maxRow][mid] >= left && mat[maxRow][mid] >= right) {
                return new int[] { maxRow, mid };

            }
            if(mat[maxRow][mid]<left){
                high=mid-1;
            }else{
                low=mid+1;

            }
        }
        return new int[]{-1,-1}; 
         

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 8, 10, 10 },
                { 14, 13, 12, 11 },
                { 15, 9, 11, 21 },
                { 16, 17, 19, 20 }
        };

        int[] peak = findPeakElem(matrix);
        System.out.println("Peak found at: (" + peak[0] + ", " + peak[1] + ")");
        int[] peak1 = findPeakElemOptimized (matrix);
        System.out.println("Peak found at: (" + peak1[0] + ", " + peak1[1] + ")");
    }

}
