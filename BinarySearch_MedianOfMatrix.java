import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch_MedianOfMatrix {
    public static int medians(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(arr[i][j]);
            }
        }
        Collections.sort(list);
        return list.get((n * m) / 2);
    }

    public static int countLessEqual(int row[],int target){
        int low=0;
        int high=row.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(row[mid]<=target){
                low=mid+1;

            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public static int mediansOptimal(int arr[][]){
        int row=arr.length;
        int col=arr[0].length;
        int low=arr[0][0];
        int high=arr[row-1][col-1];
        while(low<high){
            int mid=(low+high)/2;
            int count=0;
            for(int i =0;i<row;i++){
                count+=countLessEqual(arr[i],mid);

            }
            if(count<(row*col)/2+1){
                low=mid+1;

            }else{
                high=mid;
            }
        }
        return low;

    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };

        System.out.println("Median: " + medians(matrix)); 
        System.out.println("Median: " + mediansOptimal(matrix)); 

   
    }
}
