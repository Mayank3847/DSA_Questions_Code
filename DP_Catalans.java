import java.util.Arrays;

public class DP_Catalans {
    //CATALANS BY RECURSSION ----
    public static int catalans(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalans(i) * catalans(n - i - 1);
        }
        return ans;
    }



//CATALANS BY MEMOIZATION 
    public static int catalansByMemo(int n ,int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
           return  dp[n];

        }
        int ans=0;
        for(int i =0;i<n;i++){
            ans+=catalansByMemo(i, dp)*catalansByMemo(n-i-1, dp);
        }
        return dp[n]=ans;

    }



    //CATALANS BY TABULATION 
    public static int catalansByTab(int n ){
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];

            }

        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        int dp[]=new int [n+1];
        // for(int i=0;i<n+1;i++){
        //     dp[i]=-1;
        // }
        Arrays.fill(dp, -1);
        System.out.println("THE CATALANS NUMBER OF " + n + "  by recurssion is : " + catalans(n));
        System.out.println("THE CATALANS NUMBER OF " + n + "  by memoization is : " + catalansByMemo(n,dp));
        System.out.println("THE CATALANS NUMBER OF " + n + "  by tabulation is : " + catalansByTab(n));


    }

}
