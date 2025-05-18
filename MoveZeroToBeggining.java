import java.util.Arrays;

public class MoveZeroToBeggining {
    public static int[] moveZeroToBeggining(int arr[]){
        int n = arr.length;
        int idx=n-1;
        for(int i =n-1;i>=0;i--){
            if(arr[i]!=0){
                arr[idx]=arr[i];
                idx--;
            }

        }
        while(idx>=0){
            arr[idx]=0;
            idx--;
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[]={0,1,0,2,0,3,0,4,0,5,0};
        moveZeroToBeggining(arr);
        System.out.println(Arrays.toString(arr)); 
    }
    
}
