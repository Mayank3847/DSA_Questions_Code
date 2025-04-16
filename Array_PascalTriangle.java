public class Array_PascalTriangle {
    public static int nCr(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }
        return result;
    }

    public static void pascalTriangleVariation1(int n) {
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }
    public static void pascalTriangleVariation1Optimize(int n){
        int ans=1;
        System.out.print(ans+" ");
        for(int i =1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/(i);
            System.out.print(ans+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 6; // row number
        int r = 5; // col number
        int element = nCr(n - 1, r - 1);
        System.out.println("The element at position (r,c) is: " + element);
        pascalTriangleVariation1(n);
        pascalTriangleVariation1Optimize(n);
    }

}
