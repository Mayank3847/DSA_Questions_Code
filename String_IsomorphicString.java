public class String_IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int sIndex[] = new int[200];
        int tIndex[] = new int[200];
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            if (sIndex[s.charAt(i)] != tIndex[t.charAt(i)]) {
                return false;
            }
            sIndex[s.charAt(i)] = i + 1;
            tIndex[t.charAt(i)] = i + 1;

        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

        String s3 = "paper";
        String t3 = "title";

        // Check if strings are isomorphic
        System.out.println("Is \"" + s1 + "\" and \"" + t1 + "\" isomorphic? " + isIsomorphic(s1, t1)); // true
        System.out.println("Is \"" + s2 + "\" and \"" + t2 + "\" isomorphic? " + isIsomorphic(s2, t2)); // false
        System.out.println("Is \"" + s3 + "\" and \"" + t3 + "\" isomorphic? " + isIsomorphic(s3, t3)); // true
    
    }
}
