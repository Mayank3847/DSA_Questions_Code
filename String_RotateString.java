public class String_RotateString {
    public static boolean rotatedString(String s ,String goal){
        if(s.length()!=goal.length()){
            return false;
        }
        for(int i =0;i<s.length();i++){
            s=s.substring(1)+s.charAt(0);
            if(s.equals(goal)){
                return true;

            }
        }
        return false;
    }
    public static boolean rotatedStringOptimized(String s ,String goal){
        if(s.length()!=goal.length()){
            return false;
        }
        return (s+s).contains(goal);
    }
    public static void main(String[] args) {
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println("Can \"" + s1 + "\" be rotated to \"" + goal1 + "\"? " + rotatedString(s1, goal1)); // true

        // Example 2
        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println("Can \"" + s2 + "\" be rotated to \"" + goal2 + "\"? " + rotatedString(s2, goal2)); // false
        String s3 = "abcde";
        String goal3 = "cdeab";
        System.out.println("Can \"" + s3 + "\" be rotated to \"" + goal3 + "\"? " + rotatedStringOptimized(s3, goal3)); // true

        // Example 2
        String s4 = "abcde";
        String goal4 = "abced";
        System.out.println("Can \"" + s4+ "\" be rotated to \"" + goal4 + "\"? " + rotatedStringOptimized(s4, goal4)); // false
    
   
    }
    
}
