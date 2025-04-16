import java.util.*;

public class Array_QuadSumAsTarget {
    public static List<List<Integer>> fourSum(int arr[], int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int sum = arr[i] + arr[j];

                        sum += arr[k];
                        sum += arr[l];
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(temp);
                            set.add(temp);

                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    

    //Better Approach 
    public static List<List<Integer>> fourSumBetter(int arr[],int target){
        int n =arr.length;
        Set<List<Integer>>ans=new HashSet<>();
        for(int i =0;i<n;i++){
            for(int j =i+1;j<n;j++){
                Set<Integer>temp=new HashSet<>();
                for(int k=j+1;k<n;k++){
                    int fourth=target-(arr[i]+arr[j]+arr[k]);
                    if(temp.contains(fourth)){
                        List<Integer>result=Arrays.asList(arr[i],arr[j],arr[k],fourth);
                        ans.add(result);
                    }

                    }
                }
            }
            List<List<Integer>>finalAns=new ArrayList<>(ans);
            return finalAns;
        }


        //Optimal Approach
        public static List<List<Integer>>fourSumOptimal(int arr[],int target){
            int n =arr.length;
            List<List<Integer>>ans=new ArrayList<>();
            Arrays.sort(arr);
            for(int i =0;i<n;i++){
                if(i>0&&arr[i]==arr[i-1]){
                    continue;
                }
                for(int j =i+1;j<n;j++){
                    if(j>i+1&&arr[j]==arr[j-1]){
                        continue;

                    }
                    int k =j+1;
                    int l=n-1;
                    while(k<l){
                        int sum= arr[i]+arr[j]+arr[k]+arr[l];
                        if(sum==target){
                            List<Integer>temp=Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            ans.add(temp);
                            k++;
                            l--;
                            while(k<l&&arr[k]==arr[k-1]){
                                k++;
                            }
                            while(k<l&&arr[l]==arr[l+1]){
                                l--;
                            }
                        }else  if(sum<target){
                            k++;
                        }else{
                            l--;
                        }
                    }
                }

            }
            return ans;

        }
    

    public static void main(String[] args) {
        int[] nums = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
        int target = 9;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        List<List<Integer>> ans1 = fourSum(nums, target);
        System.out.println("The quadruplets are (Better Approach): ");
        for (List<Integer> it : ans1) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        List<List<Integer>> ans2 = fourSum(nums, target);
        System.out.println("The quadruplets are (Optimal Approach): ");
        for (List<Integer> it : ans2) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
