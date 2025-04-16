import java.util.*;

public class Stack_Prefix_Postfix {
    public static String prefixToPostfix(String s) {
        Stack<String> st = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();
                String converted = t1 + t2 + ch;
                st.push(converted);

            }
        }
        return st.pop();

    }
    public static void main(String[] args) {
        String exp = "/-AB*+DEF";
        System.out.println("Prefix Expression : "+exp);
        System.out.println("Postfix Expression : "+prefixToPostfix(exp));
    }

}
