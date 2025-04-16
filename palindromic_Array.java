import java.util.*;

/**
 * palindromic_Array----- return 1 or 0 when the elements of an array is in palindrom or not 
 * 
 */
public class palindromic_Array {

    public static int palindromeArray(int arr[], int n) {
        int ans = 1;
        for (int i = 0; i < n; i++) {
            String str = Integer.toString(arr[i]);
            if (ans == 0) {
                break;
            }
            for (int j = 0; j < str.length() - j - 1; j++) {
                int x = str.length() - j - 1;
                if (str.charAt(j) == str.charAt(x)) {
                    ans = 1;

                } else {
                    ans = 0;
                }

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE SIZE OF THE ELEMENT");
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();

        }
        System.out.println(palindromeArray(arr, length));
        sc.close();
    }
}