import java.util.*;
import java.util.ArrayList;

public class Array_tripletAs0 {
    public static List<List<Integer>> triplet(int arr[]) {
        Set<List<Integer>> st = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> tempList = Arrays.asList(arr[i], arr[j], arr[k]);
                        tempList.sort(null);
                        st.add(tempList);

                    }
                }

            }
        }
        List<List<Integer>> list = new ArrayList<>(st);
        return list;
    }

    // For Better Approach------>
    public static List<List<Integer>> tripletBetter(int arr[]) {
        int n = arr.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]);
                if (temp.contains(third)) {
                    List<Integer> list = Arrays.asList(arr[i], arr[j], third);
                    list.sort(null);

                }
                temp.add(arr[j]);
            }

        }
        List<List<Integer>> ans = new ArrayList<>(result);
        return ans;

    }

    //For Optimal Approach--
    public static List<List<Integer>> tripletOptimal(int arr[]){
        int n = arr.length;
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(arr);
        for(int i =0;i<n;i++){
            if(i!=0&&arr[i]==arr[i-1]){
                continue;

            }
            int j=i+1;
            int k =n-1;
            while(j<k){
                int sum=0;
                sum= arr[i]+arr[j]+arr[k];
                if(sum<0){
                    j++;
                    
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer>temp=new ArrayList<>();
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k&&arr[j]==arr[j-1]){
                        j++;
                    }
                    while(j<k&&arr[k]==arr[k+1]){
                        k--;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        // int n = arr.length;
        List<List<Integer>> ans = triplet(arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] , ");
        }
        System.out.println("null");
        System.out.println("Better Approach ");

        List<List<Integer>> ans1 = triplet(arr);
        for (List<Integer> it : ans1) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] , ");
        }
        System.out.println("null");
        System.out.println("Optimal Approach ----> ");

        List<List<Integer>> ans2 = triplet(arr);
        for (List<Integer> it : ans2) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] , ");
        }
        System.out.println("null");
    }
}
