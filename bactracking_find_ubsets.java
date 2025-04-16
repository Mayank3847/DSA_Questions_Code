public class bactracking_find_ubsets {
   public static void findSubsets(String str, String newstr, int index) {
      if (index == str.length()) {
         if (newstr.length() == 0) {
            System.out.println("null");
         } else {
            System.out.println(newstr);
         }
         return;
      }
      // ffindSubsets(str, newstr, index);
      // findSubsets(str, index+1, newstr.charAt(index));
      findSubsets(str, newstr + str.charAt(index), index + 1);
      findSubsets(str, newstr, index + 1);

   }

   public static void main(String[] args) {
      String str = "ABCD";
      findSubsets(str, "", 0);
   }
}
