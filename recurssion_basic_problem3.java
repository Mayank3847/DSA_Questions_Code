public class recurssion_basic_problem3 {
    public static int length_Of_string(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return length_Of_string(str.substring(1)) + 1;
    }

    public static void main(String[] args) {
        String str = "mayank";
        System.out.println(length_Of_string(str));
    }

}
