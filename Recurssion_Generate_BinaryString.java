import java.util.ArrayList;
import java.util.List;

public class Recurssion_Generate_BinaryString {
    public static void generateBinaryString(int n, String str, char lastChar) {
        if (str.length() == n) {
            System.out.print(str+" ");
            return;
        }
        generateBinaryString(n, str + "0", '0');
        if (lastChar != '1') {
            generateBinaryString(n, str + "1", '1');
        }
        return;
    }



    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        generate(n, "", '0', result);
        return result;
    }

    private static void generate(int n, String str, char lastChar, List<String> result) {
        if (str.length() == n) {
            result.add(str);
            return;
        }

        generate(n, str + "0", '0', result);

        if (lastChar != '1') {
            generate(n, str + "1", '1', result);
        }
    }


    public static List<String> generateBinaryStrings_0(int n) {
        List<String> result = new ArrayList<>();
        generate_0(n, "", '1', result);
        return result;
    }

    private static void generate_0(int n, String str, char lastChar, List<String> result) {
        if (str.length() == n) {
            result.add(str);
            return;
        }

        generate_0(n, str + "1", '1', result);
        
        if (lastChar != '0') {
            generate_0(n, str + "0", '0', result);
        }
    }
    

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Binary strings of length " + n + " without consecutive 1s:");
        generateBinaryString(n, "", '0');
        System.out.println();
        
        
        List<String> binaryStrings = generateBinaryStrings(n);
        
        System.out.println("Binary strings of length " + n + " without consecutive 1s:");
        System.out.println(String.join(" ", binaryStrings));



        List<String> binaryStrings1 = generateBinaryStrings_0(n);
        
        System.out.println("Binary strings of length " + n + " without consecutive 0s:");
        System.out.println(String.join(" ", binaryStrings1));
    }
}
