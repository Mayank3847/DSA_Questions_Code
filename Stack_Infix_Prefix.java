import java.util.*;

public class Stack_Infix_Prefix {

    public static int operatorPrecedency(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }

    public static String reversedString(String s) {
        StringBuilder reversed = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(')
                reversed.append(')');
            else if (ch == ')') {
                reversed.append('(');
            }

            else {
                reversed.append(ch);

            }

        }
        return reversed.toString();

    }                                 

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    public static String infixToPrefix(String s) {
        String reversed = reversedString(s);
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            } else if (ch == '(') {
                st.push(ch);

            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
            } else if (isOperator(ch)) {
                while (!st.isEmpty() && operatorPrecedency(ch) < operatorPrecedency(st.peek()))
                    sb.append(st.pop());
                st.push(ch);

            }

        }
        while (!st.isEmpty()) {
            sb.append(st.pop());

        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String s = "(A+B)*C-D+F";
        System.out.println("Infix Expression : " + s);
        System.out.println("Prefix Expression : " + infixToPrefix(s));
        ;
    }
}