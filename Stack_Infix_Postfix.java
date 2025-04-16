import java.util.*;

public class Stack_Infix_Postfix {
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

    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop();

            } else {
                while (!stack.isEmpty() && operatorPrecedency(stack.peek()) >= operatorPrecedency(ch)) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            output.append(stack.pop());
        }
        return output.toString();

    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)";
        System.out.println("Infix Expession : " + s);
        System.out.println("Postfix Expression : " + infixToPostfix(s));

    }

}
