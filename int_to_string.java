import java.util.*;
public class int_to_string {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("ENTER YOUR INTEGER VALUE:");
        int n = sc.nextInt();
        String str=""+n;
        if(!str.isEmpty()){
            System.out.println("GOOD JOB!!");
        }
        else{
            System.out.println("WRONG ANSWER");
        }
sc.close();
    }
    
}
