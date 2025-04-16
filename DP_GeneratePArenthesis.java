public class DP_GeneratePArenthesis {
    static int parenthesisCount(int pos, int n, int open, int close) {
        if (close == n) {
            return 1;  
        }
        
        int count = 0;
        
        
        if (open > close) {
            count += parenthesisCount(pos + 1, n, open, close + 1);
        }
        
        if (open < n) {
            count += parenthesisCount(pos + 1, n, open + 1, close);
        }
        
        return count;
    }

    static int countParenthesis(int n) {
        if (n > 0)
            return parenthesisCount(0, n, 0, 0);
        return 0;
    }


    public static void printparenthesis(char [] str,int pos,int n,int open,int close){
        if(close==n){
            for(int  i =0;i<str.length;i++){
                System.out.print(str[i]+" ");
            }
                System.out.println();
                return ;
        }
        else{
            if(open>close){
                str[pos]='}';
                printparenthesis(str, pos+1, n, open, close+1);
            }
            if(open<n){
                str[pos]='{';
                printparenthesis(str, pos+1, n, open+1, close);
            }
        }
    }
    static void balancedParenthesis(char str[],int n ){
        if(n>0){
            printparenthesis(str, 0, n, 0, 0);
        }
        return;
    }
    public static void main(String[] args) {
        int n =4;
        char str[]=new char[2*n];
        balancedParenthesis(str, n);
        System.out.println("Number of balanced parentheses combinations for n = " + n + " is: " + countParenthesis(n));
    }
    
}
