import java.util.Scanner;

public class binaryOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER1:");
        int a = sc.nextInt();
        System.out.println("ENTER THE NUMBER2:");
        int b = sc.nextInt();
        
        int choice;
        do {
            // Display the menu
            System.out.println("Binary Operations Calculator");
            System.out.println("1. AND");
            System.out.println("2. OR");
            System.out.println("3. XOR");
            System.out.println("4. NOT (for one number)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    int andResult = a & b;
                    System.out.println("Result of " + a + " AND " + b + " is: " + andResult);
                    System.out.println("Binary representation: " + Integer.toBinaryString(andResult));
                    break;

                case 2:
                    int orResult = a | b;
                    System.out.println("Result of " + a + " OR " + b + " is: " + orResult);
                    System.out.println("Binary representation: " + Integer.toBinaryString(orResult));
                    break;

                case 3:
                    int xorResult = a ^ b;
                    System.out.println("Result of " + a + " XOR " + b + " is: " + xorResult);
                    System.out.println("Binary representation: " + Integer.toBinaryString(xorResult));
                    break;

                case 4:
                    int notResult = ~a;
                    System.out.println("Result of NOT " + a + " is: " + notResult);
                    System.out.println("Binary representation: " + Integer.toBinaryString(notResult));
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
        
        sc.close();
    }
}
