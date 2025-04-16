public class backtracking_permutation_finding {
    private static int counter = 0;
    public static void permutation_finding(String str,String newString){
        if (str.length()==0) {
            System.out.println(newString);
            counter++;
            return;
            
        }
        for(int i =0;i<str.length();i++){
            char currentChar=str.charAt(i);
           String str1=str.substring(0, i)+str.substring(i+1);
            permutation_finding(str1, newString+currentChar);
        }
        
    }
    public static void main(String[] args) {
        String str="abc";
        permutation_finding(str ,"");
        System.out.println("THE TOTAL NUMBER OF PERMUTATION OF "+str+" :"+counter);
    }
    
}
