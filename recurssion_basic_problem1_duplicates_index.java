public class recurssion_basic_problem1_duplicates_index {
    public static void alloccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return;

        }
        if (arr[i] == key) {
            System.out.print(i + " ");
        }
        alloccurence(arr, key, i + 1);

    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, 3, 6, 2, 5, 8, 2, 2, 9, 7, 2, 2 };
        int key = 10;
        alloccurence(arr, key, 0);
        System.out.println();
    }

}
