public class Array_MissingNumber {
    public static int missingNumber(int arr[]) {
        int n = arr.length;
        for (int i = 1; i <= n; i++) {
            int flag = 0;
            for (int j = 0; i < n - 1; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;

                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return n + 1;
    }

    // for better approach
    public static int missingNumberBetter(int arr[]) {
        int n = arr.length;
        int hash[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 1 && arr[i] <= n) {

                hash[arr[i]]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return n + 1;
    }

    // FOR OPTIMAL APPROACH
    public static int missingNumberOptimal(int arr[]) {
        int n = arr.length;
        int s1 = (n * (n + 1)) / 2;
        int s2 = 0;
        for (int i = 0; i < n - 1; i++) {
            s2 += arr[i];
        }
        int missing=s1-s2;
        return missing;
    }

    public static void main(String[] args) {
        // int N = 5;
        int arr[] = {1,2,4,5};

        int ans = missingNumber(arr);
        System.out.println("The missing number is: " + ans);
        int ansBetter = missingNumberBetter(arr);
        System.out.println("The missing number(Better Approach) is: " + ansBetter);

        int ansOptimal=missingNumberOptimal(arr);
        System.out.println("The missing number(Optimal Approach) is: " + ansOptimal);



    }

}
