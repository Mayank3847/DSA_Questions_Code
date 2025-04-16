public class BinarySearch_Capacity_to_Ship_Packages_within_D_Days {

    public static int findDays(int weight[],int capacity){
        int days=1;
        int load=0;
        int n=weight.length;
        for(int i =0;i<n;i++){
            if(load+weight[i]>capacity){
                days+=1;
                load=weight[i];

            }else{
                load+=weight[i];

            }
        }
        return days;
    }
    public static int leastWeightCapacity(int weight[],int d){
        int maxi=Integer.MIN_VALUE;
        int n = weight.length;
        int sum=0;
        for(int i =0;i<n;i++){
            sum+=weight[i];
            maxi=Math.max(maxi,weight[i]);

        }
        for(int i =maxi;i<=sum;i++){
            if(findDays(weight, i)<=d){
                return i;
            }
        }
        return -1;
    }
    public static int findDaysOptimal(int weight[] ,int capacity ){
        int days=1;
        int load=0;
        int n= weight.length;
        for(int i =0;i<n;i++){
            if(load+weight[i]>capacity){
                days+=1;
                load=weight[i];

            }else{
                load+=weight[i];

            }
        }
        return days;
    }
    public static int leastWeightCapacityOptimal(int weight[],int d){
        int low=Integer.MIN_VALUE;
        int high=0;
        int n =weight.length;
        for(int i =0;i<n;i++){
            high+=findDays(weight, i);
            low=Math.max(low,weight[i]);

        }
        while(low<=high){
            int mid=(low+high)/2;
            int numberOfDays=findDays(weight, mid);
            if(numberOfDays<=d){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = leastWeightCapacity(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
        int ans1 = leastWeightCapacity(weights, d);
        System.out.println("The minimum capacity (Optimal Approach) should be: " + ans1);
   
    }
}