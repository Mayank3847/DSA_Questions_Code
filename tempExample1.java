import java.util.*;

class tempExample1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE TEMPERATURE OF THE BODY:");
        double temp = sc.nextDouble();
        if (temp > 100) {
            System.out.println("YOU HAVE A FEVER :THE TEMPERATURE OF BODY IS :" + temp);

        } else {
            System.out.println("YOU DONT HAVE A FEVER :THE TEMPERATURE OF THE BODY IS " + temp);
        }
        sc.close();
    }
}
