import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
public class Graph_WordLadder {
    static class Pair{
        String first;
        int second;
        Pair(String first,int second){
            this.first=first;
            this.second=second;

        }
        
    }
    public static int wordLadderLength(String startWord,String targetWord,String wordList[]){
        Queue<Pair>q=new LinkedList<>();
        Set <String>st=new HashSet<>();
        int len=wordList.length;
        for(int i  =0;i<len;i++){
            st.add(wordList[i]);

        }
        q.add(new Pair(startWord, 1));
        st.remove(startWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            if(word.equals(targetWord)==true){
                return steps;
            }
            for(int i =0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedArray[]=word.toCharArray();
                    replacedArray[i]=ch;
                    String replaceWord=new String(replacedArray);
                    if(st.contains(replaceWord)==true){
                        st.remove(replaceWord);
                        q.add(new Pair(replaceWord, steps+1));

                    }
                }
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = wordLadderLength(startWord, targetWord, wordList);
        if (result == 0) {
            System.out.println("No transformation possible.");
        } else {
            System.out.println("Shortest transformation sequence length: " + result);
        }
    }

    
}
