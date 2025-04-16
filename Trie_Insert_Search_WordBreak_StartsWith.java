public class Trie_Insert_Search_WordBreak_StartsWith {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;// eow---End Of Words

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
//insert
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {

                curr.children[idx] = new Node();
            }

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();

            }

            curr = curr.children[idx];
        }
        curr.eow = true;
    }
//search
    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;

            } else {
                curr = curr.children[idx];
            }
        }
        return curr.eow;

    }
//Starts with problem  
    public static boolean startsWith(String prefix) {
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;

            }
            curr=curr.children[idx];
        }
return true ;
        
    }
//Word break problem
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String word[] = { "i", "like", "sam", "samsung", "any", "thee", "apple","app","mango","man","woman"};
        String key = "ilikesamsung";
      //  String word1[]={"apple","app","mango","man","woman"};
        String prefix="moon";

        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        System.out.println(wordBreak(key));
        System.out.println(search("there"));
        System.out.println(search("thee"));
        System.out.println(startsWith(prefix));

    }

}
