import java.util.*;
public class String_Maximum_Depth_Of_The_Parenthesis {
    public static int MaximumDepthParenthesis(String s){
        int result=0;
        Stack<Character>st=new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(ch);
            
            }else if(ch==')'){
                st.pop();
            }
            result=Math.max(result,st.size());
        }
        return result;
    }
    public static int MaximumDepthParenthesis_SpaceOptimized(String s){
        int bracket=0;
        int result=0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
               bracket++;
            
            }else if(ch==')'){
              bracket--;
            }
            result=Math.max(result,bracket);
        }
        return result;

    }
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        int output=MaximumDepthParenthesis(s);
        System.out.println("String_Maximum_Depth_Of_The_Parenthesis "+output);
        int output1=MaximumDepthParenthesis_SpaceOptimized(s);
        System.out.println("String_Maximum_Depth_Of_The_Parenthesis "+output1);
    }
}
