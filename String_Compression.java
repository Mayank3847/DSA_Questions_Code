import java.util.*;

public class String_Compression {
    public static String ComprssionString(String str) {
        String newStr = " ";
        for (int i = 1; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;

            }
            newStr += str.charAt(i);
            if (count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE STRING:");
        String str = sc.nextLine();
        System.out.println("COMPRESSED STRINGS :-----" + ComprssionString(str));
        sc.close();
    }

}
