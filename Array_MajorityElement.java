import java.util.*;

public class Array_MajorityElement {
    public static List<Integer> majorityElement(int arr[]) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ans.size() == 0 || ans.get(0) != arr[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[j] == arr[i]) {
                        count++;

                    }
                }
                if (count > (n / 3)) {
                    ans.add(arr[i]);
                }

                if (ans.size() == 2) {
                    break;
                }
            }

        }
        return ans;
    }

    public static List<Integer> majorityElementBetter(int arr[]) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int mini = (int) (n / 3);
        for (int i = 0; i < n; i++) {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value + 1);
            if (map.get(arr[i]) == mini) {
                ans.add(arr[i]);

            }
            if (ans.size() == 2) {
                break;
            }
        }
        return ans;
    }

    // Optimal Approach -->
    public static List<Integer> majorityElementOptimized(int[] arr) {
        int n = arr.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && element2 != 0) {
                cnt1 = 1;
                element1 = arr[i];

            } else if (cnt2 == 0 && element1 != arr[i]) {
                cnt2 = 1;
                element2 = arr[i];
            } else if (arr[i] == element1) {
                cnt1++;
            } else if (arr[i] == element2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element1) {
                cnt1++;
            }
            if (arr[i] == element2) {
                cnt2++;
            }
        }
        int mini = (int) (n / 3) + 1;
        if (cnt1 >= mini) {
            ans.add(element1);

        }
        if (cnt2 >= mini) {
            ans.add(element2);
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] arr = { 2, 1, 6, 6, 6, 6, 6, 5, 5, 5, 5 };
        Arrays.sort(arr);
        List<Integer> ans = majorityElement(arr);
        List<Integer> ans1 = majorityElementBetter(arr);
        List<Integer> ans2 = majorityElementOptimized(arr);

        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
        System.out.print("The majority elements are (Better Approach): ");

        for (int i = 0; i < ans1.size(); i++) {
            System.out.print(ans1.get(i) + " ");
        }
        System.out.println();
        System.out.print("The majority elements are (Optimal Approach): ");

        for (int i = 0; i < ans2.size(); i++) {
            System.out.print(ans2.get(i) + " ");
        }

    }

}
