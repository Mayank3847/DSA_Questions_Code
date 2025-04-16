public class move_All_X_Recurssion {
    public static void move_All_X(String str, int index, int count, String newString) {
        if (index == str.length()) {
            for (int i = 0; i < count; i++) {
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }
        char currentChar = str.charAt(index);
        if (currentChar == 'x') {
            count++;
            move_All_X(str, index + 1, count, newString);
        } else {
            newString += currentChar;
            move_All_X(str, index + 1, count, newString);
        }
    }

    public static void main(String[] args) {
        String str = "axbcxxd";
        move_All_X(str, 0, 0, " ");
    }
}
