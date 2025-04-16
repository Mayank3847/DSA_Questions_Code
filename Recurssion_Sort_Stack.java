import java.util.*;
public class Recurssion_Sort_Stack {

    public static void sortedInsert(Stack<Integer> s,int num){
        if(s.isEmpty()||s.peek()>=num){
            s.push(num);
            return;
        }
        int n=s.peek();
        s.pop();
        sortedInsert(s,num);
        s.push(n);
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()){
            return s;
        }
        int num=s.peek();
        s.pop();
        sort(s);
        sortedInsert(s,num);
        return s;
        // add code here.
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(2);
        s.push(9);
        s.push(1);
        s.push(6);

        Recurssion_Sort_Stack solution= new Recurssion_Sort_Stack();
        Stack<Integer> sortedStack = solution.sort(s);

        System.out.println("Sorted Stack (Descending Order): " + sortedStack);
    }
}