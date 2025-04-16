public class BitManipulation_Get_Set_Clear {
    static void bitManipulation(int num, int i) {
        // code here
        int getBit = (num >> (i - 1)) & 1;

        // Set the i-th bit
        int setBit = num | (1 << (i - 1));

        // Clear the i-th bit
        int clearBit = num & ~(1 << (i - 1));

        // Print the results in a single line without extra spaces
        System.out.print(getBit + " " + setBit + " " + clearBit);
    }

    public static void main(String[] args) {
        int num = 70;
        int i = 3;
        bitManipulation(num, i);
    }

}
