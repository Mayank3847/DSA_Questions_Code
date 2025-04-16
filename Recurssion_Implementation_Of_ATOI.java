public class Recurssion_Implementation_Of_ATOI {

    public static int myAtoi(String str){
        str=str.trim();
        if(str.isEmpty()){
            return 0;

        }
        int sign =1;
        int index=0;
        if(str.charAt(0)=='+'||str.charAt(0)=='-'){
            if(str.charAt(0)=='-'){
                sign=-1;
            }
            if(str.charAt(0)==1){
                sign=1;
            }
            index++;
        }
        return helper(str,index,0,sign);

    }
    public static int helper(String str,int index,int result,int sign){
        if(index>=str.length()||!Character.isDigit(str.charAt(index))){
            return result*sign;
            
        }
        int digit=str.charAt(index)-'0';
        if(result>(Integer.MAX_VALUE -digit)/10){
            if(sign==1){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;

            }
        }
        return helper(str, index+1, result*10+digit, sign);
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));             // Output: 42
        System.out.println(myAtoi("   -42"));         // Output: -42
        System.out.println(myAtoi("4193 with words"));// Ou tput: 4193
        System.out.println(myAtoi("words and 987"));  // Output: 0
        System.out.println(myAtoi("-91283472332"));   // Output: -2147483648 (Integer.MIN_VALUE)
        System.out.println(myAtoi("2147483648"));    

    }
}