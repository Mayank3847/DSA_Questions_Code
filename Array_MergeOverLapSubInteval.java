import java.util.*;

public class Array_MergeOverLapSubInteval {
    public static List<List<Integer>> mergeOverlappingSubInterval(int arr[][]) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }

        });
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {

                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);

                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));

        }
        return ans;
    }

    // Optimal Approach----->>
    public static List<List<Integer>> mergeOverlappingSubIntervalOptimal(int arr[][]) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }

        });
        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));

            } else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3},{2,4}, {8, 10},{8,9},{9,11}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = mergeOverlappingSubInterval(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
       // int[][] arr1 = ;
        List<List<Integer>> ans1 = mergeOverlappingSubIntervalOptimal(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans1) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }

}
