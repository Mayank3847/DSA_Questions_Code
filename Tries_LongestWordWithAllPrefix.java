public class Tries_LongestWordWithAllPrefix {
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

    // insert
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

    // search
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

    static String ans = " ";

    public static void LongestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){

                    ans = temp.toString();
                }

                LongestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }

        }
    }
    public static void main(String[] args) {
        String word[]={"a","app","banana","appl","apple","apply","ap"};
        for(int i =0;i<word.length;i++){
            insert(word[i]);

        }
        LongestWord(root, new StringBuilder(" "));
        System.out.println(ans);
    }

}
