import java.util.*;
public class String_Sort_By_Frequency {
    public static String frequencySort(String s) {
        int[] frequency = new int[128];
        char[] inputArray = s.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            frequency[inputArray[i]]++;
        }
        List<Character>chars=new ArrayList<>();
        for(int i =0;i<inputArray.length;i++){
            if(!chars.contains(inputArray[i])){
                chars.add(inputArray[i]);
            }
        }
        for(int i =0;i<chars.size();i++){
            for(int j=i+1;j<chars.size();j++){
                if(frequency[chars.get(i)]<frequency[chars.get(j)]){
                char temp=chars.get(i);
                chars.set(i, chars.get(j));
                chars.set(j, temp);
                }
            }
        }
        StringBuilder result= new StringBuilder();
        for(int i =0;i<chars.size();i++){
            int count=frequency[chars.get(i)];
            while(count-->0){
                result.append(chars.get(i));

            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String input ="abacadbdcabe";
        String output=frequencySort(input);
         System.out.println("Sorted by frequency: " + output);
    }
}
