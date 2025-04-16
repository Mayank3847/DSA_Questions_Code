public class BinarySearch_Search_Row_Col_Wise {
    public static boolean searchElementRowColWise(int arr[][],int target){
        int n = arr.length;
        int m = arr[0].length;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(arr[i][j]==target){
                    return true;
                }
            }
        
        }
        return false;
    }
    public static boolean searchElementRowColWiseBetter(int arr[][], int target) {
        int n = arr.length;
        // int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            if (binarySearch(arr[i], target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int arr[], int target) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
    public static boolean searchElementRowColWiseOptimal(int arr[][],int target){
        int n = arr.length;
        int m = arr[0].length;
        int row=0;
        int col=m-1;
        while(row<n&&col>=0){
            if(arr[row][col]==target){
                return true;

            }
            else if(arr[row][col]<target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

public static void main(String[] args) {
    int[][] matrix = {
        { 1, 3, 5, 7 },
        { 2, 6, 8, 10 },
        { 4, 9, 12, 15 },
        { 11, 14, 16, 20 }
};
int target=20;
// boolean result1=searchElementRowColWise(matrix, target);
System.out.println("Target " + target + " found: " + searchElementRowColWiseBetter(matrix, target));
System.out.println("Target " + target + " found: " + searchElementRowColWise(matrix, target));
System.out.println("Target " + target + " found: " + searchElementRowColWiseOptimal(matrix, target));


}
}
