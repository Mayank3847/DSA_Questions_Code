public class Array_MaximumSubArrayProduct {
    public static int maximumProductSub(int arr[]) {
        int n = arr.length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= arr[k];
                    result = Math.max(result, prod);

                }
            }

        }
        return result;
    }

    public static int maximumProductSubBetter(int arr[]) {
        int n = arr.length;
        int result = arr[0];
        for (int i = 0; i < n - 1; i++) {
            int prod = arr[i];
            for (int j = i + 1; j < n; j++) {
                prod *= arr[j];
            }
            result = Math.max(prod, result);
        }
        return result;
    }

    public static int maximumProductSubOptimal1(int arr[]) {
        int n = arr.length;
        int pref = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pref == 0) {
                pref = 1;

            }
            if (suff == 0) {
                suff = 1;
            }
            pref *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pref, suff));

        }
        return ans;
    }

    public static int maximumProductSubOptimal2(int arr[]) {
        int n = arr.length;
        int prod1 = arr[0];
        int prod2 = arr[0];
        int result = arr[0];
        for (int i = 0; i < n; i++) {
            int temp = Math.max(arr[i], Math.max(prod1 * arr[i], prod2 * arr[i]));
            prod2 = Math.min(arr[i], Math.min(prod1 * arr[i], prod2 * arr[i]));
            prod1 = temp;
            result = Math.max(result, prod1);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, -3, 0, -4, -5 };
        int ans = maximumProductSub(arr);
        System.out.println("The maximum product subarray is: " + ans);
        int ans1 = maximumProductSubBetter(arr);
        System.out.println("The maximum product subarray is(Better Approach): " + ans1);
        int ans2 = maximumProductSubOptimal1(arr);
        System.out.println("The maximum product subarray is(Optimal Approach1): " + ans2);
        int ans3 = maximumProductSubOptimal2(arr);
        System.out.println("The maximum product subarray is(Optimal Approach1): " + ans3);

    }

}
