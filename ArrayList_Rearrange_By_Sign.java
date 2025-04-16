import java.util.*;

public class ArrayList_Rearrange_By_Sign {
    public static int[] rearrange(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                positive.add(arr[i]);
            } else {
                negative.add(arr[i]);
            }
        }
        for (int i = 0; i < n / 2; i++) {
            arr[2 * i] = positive.get(i);
            arr[2 * i + 1] = negative.get(i);
        }
        return arr;

    }
    public static int[] rearrangeOptimal(int []arr){
        int n=arr.length;
        int []result=new int [n];
        int posIndex=0,negIndex=1;

        for(int i =0;i<n;i++){
            if(arr[i]>=0){
                result[posIndex]=arr[i];
                posIndex+=2;
            }else{
                result[negIndex]=arr[i];
                negIndex+=2;
            }
        }
       return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int A[] = { 1, 2, -4, -5 };

        int[] ans = rearrange(A);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }

    
            int[] arr = rearrangeOptimal(A);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

