import java.util.*;
public class Tries_Group_Anagram {
    
    public List<List<String>> Anagrams(String[] string_list) {
        
         if(string_list==null ||string_list.length==0){
            return new ArrayList<>();
        }
            Map<String,List<String>>map=new HashMap<>();
            for(int i =0;i<string_list.length;i++){
                String s=string_list[i];
                char[]arr=s.toCharArray();
                Arrays.sort(arr);
                String key=String.valueOf(arr);
                if(!map.containsKey(key)){
                    map.put(key,new ArrayList<>());

                }
                map.get(key).add(s);

            }
            List<List<String>>result=new ArrayList<>();
           List<Map.Entry<String, List<String>>> entryList = new ArrayList<>(map.entrySet());

           for (int i = 0; i < entryList.size(); i++) {
    Map.Entry<String, List<String>> entry = entryList.get(i); 
    result.add(entry.getValue());

        }
      return result; 
    }
    public static void main(String[] args) {
        Tries_Group_Anagram solution=new Tries_Group_Anagram();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result=solution.Anagrams(input);
        System.out.println(result);
    }
}
