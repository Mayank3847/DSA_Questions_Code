public class String_SmallestWindowOfAnotherString {
    public static String smallestWindow(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] patFreq = new int[26];
        for (int i = 0; i < n; i++) {
            patFreq[s2.charAt(i) - 'a']++;
        }
        int l = 0;
        int r = 0;
        int resLen = Integer.MAX_VALUE;
        int[] window = new int[26];
        String res = null;

        while (r < m) {
            window[s1.charAt(r) - 'a']++;
            while (l <= r && isValid(window, patFreq)) {
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res = s1.substring(l, r + 1);

                }
                window[s1.charAt(l) - 'a']--;
                l++;

            }
            r++;
        }
        return res != null ? res : "";
    }

    public static boolean isValid(int arr[], int brr[]) {
        for (int i = 0; i < 26; i++) {
            if (brr[i] != 0 && brr[i] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toc";
        System.out.println("Smallest window: " + smallestWindow(s, p));

    }

}
