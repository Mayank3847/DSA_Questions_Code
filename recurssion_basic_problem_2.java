public class recurssion_basic_problem_2 {
    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    // public static void alloccurence(int number ){

    public static void printDigits(int number) {
        if (number == 0) {
            return;
        }
        int lastLast = number % 10;
        printDigits(number / 10);
        System.out.print(digits[lastLast] + " ");
    }

    public static void main(String[] args) {
        printDigits(1230);
        System.out.println();
    }
}
