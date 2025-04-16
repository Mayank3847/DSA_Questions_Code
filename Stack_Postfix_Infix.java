import java.util.*;
public class Stack_Postfix_Infix {
    static String postToInfix(String exp) {
        // code here
        Stack<String>st=new Stack<>();
        for(int i =0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
                
            }else{
                String t1=st.pop();
                String t2=st.pop();
                String solution='('+t2+ch+t1+')';
                st.push(solution);
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        String exp = "AB-DE+F*/";
        System.out.println("Postfix Expression : "+exp);
        System.out.println("Infix Expression : "+postToInfix(exp));
    }
    
}
