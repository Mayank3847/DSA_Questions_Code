public class BitManipulation_DecimalToBinary_BinaryToDecimal {
    public static String decimalToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;

        }
        return sb.reverse().toString();
    }

    public static int binaryToDecimal(String s){
        int n = s.length();
        int sum=0;
        int power=1;
        for(int i =n-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                sum+=power;
            }
            power*=2;
        }
        return sum;
    }
    public static void main(String[] args) {
        int n =7;
        String str="1101";
        System.out.println("Decimal : "+binaryToDecimal(str));
        System.out.println("Binary: " + decimalToBinary(n));
    }
}
