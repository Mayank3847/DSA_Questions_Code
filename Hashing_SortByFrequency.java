import java.util.*;
public class Hashing_SortByFrequency {
    public static String sortByfreq(String s){
        Map<Character,Integer> freqMap=new HashMap<>();
        for(int i =0;i<s.length();i++){
            char ch=s.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);

        }
        PriorityQueue<Character>maxHeap=new PriorityQueue<>((a,b)->freqMap.get(b)-freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());
        StringBuilder result=new StringBuilder();
        while(!maxHeap.isEmpty()){ 
            char curr=maxHeap.poll();
            int freq=freqMap.get(curr);
            for(int i =0;i<freq;i++){
                result.append(curr);

            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
    String s="acAbBABaca";
    System.out.println(sortByfreq(s));
    }
    
}
