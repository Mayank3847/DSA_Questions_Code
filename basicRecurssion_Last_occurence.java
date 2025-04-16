public class basicRecurssion_Last_occurence {
    public static int last_Occurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = last_Occurence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
return i;
        }
return isFound;
    }
    public static void main(String[] args) {
        int arr[]={1,5,7,8,9,5,3,5,6,5};
        System.out.println(last_Occurence(arr, 5, 0));
    }

}
