public class BitManipulation_Count1sBit {
    public static int count1sbit(int n  ){
        int cnt=0;
    while(n!=0){
        n=n&(n-1);
        cnt++;
    }
return cnt;
    }
    public static void main(String[] args) {
        int n =7;
        System.out.println(count1sbit(n));

    }
    
}
