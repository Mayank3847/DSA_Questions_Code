import java.util.*;

public class Stack_Postfix_Prefix {
    public static String postfixToPrefix(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                
                // if (st.size() < 2) { 
                //     return "Invalid postfix expression"; 
                // }
    
                String t1 = st.pop();
                String t2 = st.pop();
                st.push(ch + t2 + t1);

            }
        }
        return st.pop();

    }
    public static void main(String[] args) {
        String exp = "AB-DE+F*/";
        System.out.println("Prefix Expression : "+exp);
        System.out.println("Infix Expression : "+postfixToPrefix(exp));
    }

}
