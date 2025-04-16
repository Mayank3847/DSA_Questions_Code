import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class Graph_WordLadder2 {
    public ArrayList<ArrayList<String>> findSequence(String startWord, String targetWord, String[] wordList) {
        Set<String> st = new HashSet<String>(Arrays.asList(wordList) );
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
            Queue<ArrayList<String>> q = new LinkedList<>();
            ArrayList<String> ls = new ArrayList<>();
            ls.add(startWord);
            q.add(ls);
            ArrayList<String> usedOnLevel = new ArrayList<>();
            usedOnLevel.add(startWord);
            int level = 0;
            while (!q.isEmpty()) {
                ArrayList<String> vec = q.poll();
                if (vec.size() > level) {
                    level++;
                    for (int i = 0; i < usedOnLevel.size(); i++) {
                        st.remove(usedOnLevel.get(i));
                    }
                    usedOnLevel.clear();

                }
                String Word = vec.get(vec.size() - 1);
                if (Word.equals(targetWord)) {
                    if (ans.size() == 0) {
                        ans.add(vec);

                    } else if (ans.get(0).size() == vec.size()) {
                        ans.add(vec);
                    }
                    }
                    for (int i = 0; i < Word.length(); i++) {
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            char replacedArray[] = Word.toCharArray();
                            replacedArray[i] = ch;
                            String replacedWord = new String(replacedArray);
                            if (st.contains(replacedWord) == true) {
                                vec.add(replacedWord);
                                ArrayList<String >temp=new ArrayList<>(vec);
                                q.add(temp);
                                usedOnLevel.add(replacedWord);
                                vec.remove(vec.size()-1);

                            }
                        }
                    }
                }
            
        return ans;
}
public static void main(String[] args) {
    String startWord = "hit";
    String targetWord = "cog";
    String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

    Graph_WordLadder2 solver = new Graph_WordLadder2();
    ArrayList<ArrayList<String>> sequences = solver.findSequence(startWord, targetWord, wordList);

    if (sequences.isEmpty()) {
        System.out.println("No transformation sequences found.");
    } else {
        System.out.println("Transformation sequences:");
        for (ArrayList<String> sequence : sequences) {
            System.out.println(sequence);
        }
    }
}

}
