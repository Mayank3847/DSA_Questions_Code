import java.util.Stack;

public class CelebrityProblem {
    public static int celebrityProblem(int arr[][]){
        int n =arr.length;
        for (int i = 0; i < n; i++) {
            boolean isCelebrity = true;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arr[i][j] == 1 || arr[j][i] == 0) {
                        isCelebrity = false;
                        break;
                    }
                }
            }
            if (isCelebrity) return i; 
        }
        return -1; 
    }
    public static int celebrityProblemBetter(int arr[][]){
        int n = arr.length;
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i][j] == 1) {
                    outdegree[i]++;
                    indegree[j]++;
                }

            }
        }
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) return i;
        }
        return -1;
    }
    public static int celebrityProblemBetterStack(int arr[][]){
        int n = arr.length;
         Stack<Integer> stack = new Stack<>();
        
        
        for (int i = 0; i < n; i++) 
        {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (arr[a][b] == 1) stack.push(b); // a knows b -> a can't be celebrity
            else stack.push(a); // b can't be celebrity
        }

        int candidate = stack.pop();

        
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (arr[candidate][i] == 1 || arr[i][candidate] == 0) return -1;
            }
        }
        return candidate;

    }

    public static int celebrityProblemOptimal(int arr[][]){
        int n = arr.length;
        

        int candidate = 0;
        int i = 1;

        while (i < n) {
            if (arr[candidate][i] == 1) {
                candidate = i; 
            }
            i++;
        }
  
        for (int j = 0; j < n; j++) {
            if (j != candidate) {
                
                if (arr[candidate][j] == 1 || arr[j][candidate] == 0) {
                    return -1;
                  }
            }
        }
        return candidate;
    }
    public static void main(String[] args) {
        int[][] M = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 1}
        };

        System.out.println("Brute Force Approach Output: " + celebrityProblem(M));
        System.out.println("Better (In/Out Degree) Approach Output: " + celebrityProblemBetter(M));
        System.out.println("Stack Based Approach Output: " + celebrityProblemBetterStack(M));
        System.out.println("Optimal Two Pointer Approach Output: " + celebrityProblemOptimal(M));
   
    }
    
}
