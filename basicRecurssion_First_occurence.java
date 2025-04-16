public class basicRecurssion_First_occurence {
    public static int firstOccurence(int arr[], int key, int i) {
        if (arr[i] == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15 };
        System.out.println(firstOccurence(arr, 15, 0));
    }

}
