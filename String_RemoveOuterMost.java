public class String_RemoveOuterMost {
    
    public static String removeOuterMost(String s){
        StringBuilder ans= new StringBuilder();
        char[] arr=s.toCharArray();
        int n =  arr.length;
        int count =0;
        for(int i =1;i<n;i++){
            if(arr[i]=='('){
                count++;
                ans.append('(');
            }else{
                if(count==0){
                    i++;

                }else{
                    ans.append(')');
                    count--;
                }
            }

        }
        return ans.toString();
    }
    public static String removeOuterMostSpaceOptimized(String s){
        StringBuilder ans=new StringBuilder();
        int count =0;
        for(int i =0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(count>0){
                    ans.append(ch);

                }
                count++;
            }else{
                count--;
                if(count>0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {

        // Test case 1
        String s1 = "(()())(())";
        System.out.println("Input: s1 : " + s1);
        System.out.println("Output: s1 : " + removeOuterMost(s1)); // Expected: "()()()"

        // Test case 2
        String s2 = "(()())(())(()(()))";
        System.out.println("Input: s2: " + s2);
        System.out.println("Output: s2: " + removeOuterMost(s2)); // Expected: "()()()()(())"

        // Test case 3
        String s3 = "()()";
        System.out.println("Input: s3 " + s3);
        System.out.println("Output:  s3 :" +removeOuterMost(s3)); // Expected: ""


        // Test case 4
        String s4 = "((())())";
        System.out.println("Input: s4 :" + s4);
        System.out.println("Output: s4 :" + removeOuterMost(s4)); // Expected: "(())()"



        
        // Test case 2
        String s5 = "(()())(())(()(()))";
        System.out.println("Input: s5: " + s5);
        System.out.println("Output (Space Optimized): s5: " + removeOuterMostSpaceOptimized(s5)); // Expected: "()()()()(())"
        
        // Test case 3
        String s6 = "()()";
        System.out.println("Input: s6: " + s6);
        System.out.println("Output (Space Optimized): s6: " +removeOuterMostSpaceOptimized(s6)); // Expected: ""
        
        String s7 = "(()())(())";
        System.out.println("Input: s7: " + s7);
        System.out.println("Output (Space Optimized): s7: " + removeOuterMostSpaceOptimized(s7)); // Expected: "()()()"
    }
}