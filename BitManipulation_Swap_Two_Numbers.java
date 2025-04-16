public class BitManipulation_Swap_Two_Numbers {
     public static void main(String[] args) {
        int a=7;
        int b=5;
        System.out.println("Before swap: a = " + a + ", b = " + b);

        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("After  swap: a = " + a + ", b = " + b);
 
     }
}
    