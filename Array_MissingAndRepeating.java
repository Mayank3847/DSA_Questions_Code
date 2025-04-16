public class Array_MissingAndRepeating {
    public static int[] findMissingRepeating(int[] arr) {
        int n = arr.length;
        int repeating = -1;
        int missing = -1;
        int count = 0;
        for (int i = 1; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }
            if (count >= 2) {
                repeating = i;

            } else if (count == 0) {
                missing = i;
            }
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        int ans[] = { repeating, missing };
        return ans;

    }

    // Better Approach---->
    public static int[] findMissingAndRepeatingBetter(int arr[]) {
        int n = arr.length;
        int hash[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;

        }
        int repeating = -1, missing = -1;
        for (int i = 1; i < n; i++) {
            if (hash[i] == 2) {
                repeating = i;

            } else if (hash[i] == 0) {
                missing = i;
            }
            if (repeating != -1 && missing != -1) {
                break;
            }

        }
        int ans[] = { repeating, missing };
        return ans;
    }

    //Optimal Approach-------->
    public static int[] findMissingAndRepeatingOptimal(int arr[]){
        int n =arr.length;
        long sumA=0;
        long sumSqA=0;
        long sumN=(n*(n+1))/2;
        long sumN_Sq=(n*(n+1)*(2*n+1))/6;
        for(int i =0;i<n;i++){
            sumA+=arr[i];
            sumSqA+=arr[i]*arr[i];

        }
        long val1=sumA-sumN;//X-Y
        long val2=sumSqA-sumN_Sq;//X^2-Y^2
        val2=val2/val1;//x+Y
        //x-y=z,x+y=w--->>2x=z+w,===>x=(z+w)/2
        long X=(val1+val2)/2;
        long Y=(X-val1);//x-y=z or we can say or write that val2-X--->x=z-y;
        int ans[]={(int)X,(int)Y};
        return ans;




    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 6, 7, 5 };
        int[] ans = findMissingRepeating(arr);
        int[] ans1 = findMissingAndRepeatingBetter(arr);
        int ans2[]=findMissingAndRepeatingOptimal(arr);


        System.out.println("The repeating and missing numbers are: {"
                + ans[0] + ", " + ans[1] + "}");
        System.out.println("The repeating and missing numbers(Better Approach) are: {"
                + ans1[0] + ", " + ans1[1] + "}");
                System.out.println("The repeating and missing numbers(Optimal Approach) are: {"
                + ans2[0] + ", " + ans2[1] + "}");
    }

}
