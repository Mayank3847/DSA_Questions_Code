import java.util.*;

public class Recurssion_Expression_Add_Operator {
    public static List<String> expressionAdd(String nums, int target) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length() == 0) {
            return result;
        }
        backtrack(result, nums, target, "", 0, 0, 0);
        return result;
    }

    public static void backtrack(List<String> result, String nums, int target, String exprn, long currValue,
            long prevVal,
            int index) {
        if (index == nums.length()) {
            if (currValue == target) {
                result.add(exprn);
            }
            return;
        }
        for (int i = index; i < nums.length(); i++) {
            String parts = nums.substring(index, i + 1);
            long numValue = 0;
            for (int j = 0; j < parts.length(); j++) {
                numValue = numValue * 10 + (parts.charAt(j) - '0');

            }
            if (parts.charAt(0) == '0' && parts.length() > 1) {
                break;
            }
            if (index == 0) {
                backtrack(result, nums, target, exprn + parts, numValue, numValue, i + 1);
            } else {
                // addition
                backtrack(result, nums, target, exprn + "+" + parts, currValue + numValue, numValue, i + 1);
                // substraction
                backtrack(result, nums, target, exprn + "-" + parts, currValue - numValue, -numValue, i + 1);
                // multiplicatin and maintain order prescedence
                backtrack(result, nums, target, exprn + "*" + parts, currValue - prevVal + (prevVal * numValue),
                        prevVal * numValue, i + 1);
            }
   
        }

    }
                
    public static void main(String[] args) {
        System.out.println(expressionAdd("123", 6));
        System.out.println(expressionAdd("232", 8));
        System.out.println(expressionAdd("105", 5));
        System.out.println(expressionAdd("00", 0));
        System.out.println(expressionAdd("3456237490", 9191));

    }
}
