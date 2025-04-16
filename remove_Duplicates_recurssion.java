/**
 * remove_Duplicates_recurssion
 */
public class remove_Duplicates_recurssion {

    public static void removes_Duplicates(String str, int index, StringBuilder newStr, boolean map[]) {
        if (index == str.length()) {
            System.out.println(newStr);
            return;
        }
        //opertion to be done in the program 
        char currentChar=(str.charAt(index));
        if(map[currentChar-'a']==true){
            //duplicates 
            removes_Duplicates(str, index+1, newStr, map);
        }
        else{
            map[currentChar-'a']=true;
            removes_Duplicates(str, index+1, newStr.append(currentChar), map);
        }

    }
    public static void main(String[] args) {
        String str= "mayankshekhar";
        removes_Duplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}