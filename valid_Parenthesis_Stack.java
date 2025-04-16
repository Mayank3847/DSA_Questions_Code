import java.util.*;

public class valid_Parenthesis_Stack {
    public static boolean validParenthesis(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // for opening parenthesis
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);

            } else {
                if (st.isEmpty()) {
                    return false;

                }
                //for closing bracket 
                if ((st.peek() == '(' && ch == ')')
                        || (st.peek() == '[' && ch == ']')
                        || (st.peek() == '{' && ch == '}')) {
                    st.pop();
                } else {
                    return false;
                }

            }
        }
        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "(({})[]";   
        System.out.println(validParenthesis(str));
    }

}
