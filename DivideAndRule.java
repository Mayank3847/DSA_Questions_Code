import java.util.Arrays;

public class DivideAndRule {

    public static long numOfWays(int n) {
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int len1 = i;
                    int len2 = j - i;
                    int len3 = k - j;
                    int len4 = n - k;
                    int length[] = { len1, len2, len3, len4 };
                    Arrays.sort(length);
                    if (length[0] == length[1] && length[2] == length[3] && length[0] != length[2]) {
                        cnt++;
                    }
                }
            }
        }
        return (long) cnt;
    }

    public static long numOfWaysBetter(int n) {
        if (n % 2 != 0) return 0; // if n is odd, return 0
        
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && (2 * i + 2 * j) == n) {
                    cnt++;
                }
            }
        }
        return (cnt / 2)*6; 
    }
    public static long numOfWaysOptimal(int n){
        if (n % 2 != 0) return 0;
        int  half=n/2;
        if(half%2==0){
return (half/2-1)*6L;
        }else{
            return (half/2)*6L;
        }
    }
 
    public static void main(String[] args) {
        int n = 7;
        System.out.println("Brute Force "+numOfWays(n));
        System.out.println("Better Approach "+numOfWaysBetter(n));
        System.out.println("Optimal "+numOfWaysOptimal(n));

    }
}