import java.util.*;

public class Array_PrintPascalTriangle {
    public static long ncr(int n, int r) {
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);

        }
        return result;
    } 

    public static List<List<Long>> pascalTriangle(int n) {
        List<List<Long>> ans = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            List<Long> tempList = new ArrayList<>();
            for (int col = 1; col <= row; col++) {
                tempList.add(ncr(row - 1, col - 1));
            }
            ans.add(tempList);
        }
        return ans;
    }

    // Print PascalTriangle---Optimized Way
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);


        }
        return ansRow;
    }
    public static List<List<Integer>> printPascalTriangle(int n ){
        List<List<Integer>>ans=new ArrayList<>();
        for(int row=1;row<=n;row++){
            ans.add(generateRow(row));
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Long>> ans = pascalTriangle(n);

        for (List<Long> it : ans) {
            for (long ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        List<List<Integer>> ans1 = printPascalTriangle(n);
        for (List<Integer> it : ans1) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
