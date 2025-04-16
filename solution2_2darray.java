public class solution2_2darray {
    public static void main(String[] args) {
        int nums[][] = { { 2, 5, 6 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int sum = 0;
        for (int i = 0; i < nums[0].length; i++) {
            sum += nums[1][i];

        }
        System.out.println("SUM IS:" + sum);
    }

}
