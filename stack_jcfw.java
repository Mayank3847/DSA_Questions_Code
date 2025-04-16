import java.util.Stack;

/**
 * Stack_jf
 */
public class stack_jcfw {
  // ----- question--push element at the bottom of the stack--------------------

  public static void pushAthBottom(Stack<Integer> Stack, int data) {
    if (Stack.isEmpty()) {
      Stack.push(data);
      return;
    }
    int top = Stack.pop();
    pushAthBottom(Stack, data);
    Stack.push(top);

  }

  // ---->>>>>>>>>>>>QUESTION ---------------- REVERSE A STRING USING STACK
  public static String reverseString(String str) {
    Stack<Character> st = new Stack<>();
    int index = 0;
    while (index < str.length()) {
      st.push(str.charAt(index));
      index++;

    }
    StringBuilder result = new StringBuilder("");
    while (!st.isEmpty()) {
      char curr = st.pop();
      result.append(curr);

    }
    return result.toString();
  }

  public static void main(String[] args) {
    Stack<Integer> Stack = new Stack<>();
    String str = "MAYANK";

    Stack.push(1);
    Stack.push(2);
    Stack.push(3);
    Stack.push(4);
    String result = reverseString(str);
    System.out.println("The reversed String Are- " + result);
    pushAthBottom(Stack, 5);
    while (!Stack.isEmpty()) {
      System.out.println(Stack.pop());

    }
  }
}
