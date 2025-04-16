public class String_LargestOddNumberInString {

    public static String largestOddNumberInString(String str){
        int n = str.length();
        for(int i =n-1;i>=0;i--){
            char ch=str.charAt(i);
            if((ch-'0')%2!=0){
                return str.substring(0, i+1);
            }
        }
        return " ";
    }
    public static void main(String[] args) {
        String input = "52";
        String result = largestOddNumberInString(input);
        System.out.println("Largest odd number: " + result);
    }
}