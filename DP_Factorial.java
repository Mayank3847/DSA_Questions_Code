public class DP_Factorial {
    public static long factorial(int n){
        long dp[]=new long [n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=i*dp[i-1];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n =25;
        System.out.println(factorial(n));
    }
    
}
