public class DP_WildCartMatching {
    public static boolean wildcart(String str,String ptrn){
        int n =str.length();
        int m =ptrn.length();
        boolean[][]dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;


        }
        for(int j =1;j<m+1;j++){
            if(ptrn.charAt(j-1)== '*'){
                dp[0][j]=dp[0][j-1];

            }
        }
        for(int i =1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str.charAt(i-1)==ptrn.charAt(j-1)||ptrn.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];

                }else if(ptrn.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];

                }
                else{ 
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];

    }
    public static void main(String[] args) {
        String str="baaabab";
        String ptrn="*****ba*****ab";
        System.out.println(wildcart(str, ptrn));
    }
    
}
