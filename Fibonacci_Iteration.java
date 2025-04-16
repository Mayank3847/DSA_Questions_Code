public class Fibonacci_Iteration {
    public static int printFibo(int n ){
        if(n==0){
            return 0;

        }else if(n==1){
            return 1;
        } 
        int first=0;
        int second=1;
        int next=0;
        for(int i =2;i<=n;i++){
            next=first+second;
            first=second;
            second=next;
            
        }
        return next;
    }
    public static void main(String[] args) {
        int n=10;
        System.out.println("Fibonacci number at position " + n + " is: " + printFibo(n));
    }
    
}
