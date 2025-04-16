public class friends_pairing_problem_recurssion {
    public static int friends_Pairing(int n) {

        if (n == 2 || n == 1) {
            return n;
        }
        // // for single choice
        // int friends_Pairing_single = friends_Pairing(n - 1);
        // // for pairs
        // int friends_Pairing_pairs = friends_Pairing(n - 2);
        // int pairing_ways = (n - 1) * friends_Pairing_pairs;
        // int total_ways = friends_Pairing_single + pairing_ways;
        // return total_ways;
        return friends_Pairing(n - 1) + (n - 1) * friends_Pairing(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(friends_Pairing(4));
    }
}
