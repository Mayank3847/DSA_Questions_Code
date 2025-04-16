public class recurssion_tilling_problem {
    public static int tiling_Problem(int n) {
        // 2*n(floor size)
        if (n == 0 || n == 1) {
            return 1;
        }
        // for vertical choice
        int vertical_choices = tiling_Problem(n - 1);

        // for horizontal choice
        int horizontal_choices = tiling_Problem(n - 2);

        int total_ways = vertical_choices + horizontal_choices;
        return total_ways;
    }

    public static void main(String[] args) {
        //int n = 4;
        System.out.println(tiling_Problem(4));

    }

}
