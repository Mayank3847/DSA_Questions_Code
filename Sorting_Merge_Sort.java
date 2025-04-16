public class Sorting_Merge_Sort {
    public static void Conquer(int arr[], int stIndx, int mid, int enIndx) {
        int merged[] = new int[enIndx - stIndx + 1];
        int indx1 = stIndx;
        int indx2 = mid + 1;
        int x = 0;
        // track the index of merged array
        while (indx1 <= mid && indx2 <= enIndx) {
            if (arr[indx1] <= arr[indx2]) {
                merged[x] = arr[indx1];
                x++;
                indx1++;
            }
            else{
                merged[x]=arr[indx2];
                x++;
                indx2++; 
            }
        }
        while (indx1 <= mid) {
            merged[x] = arr[indx1];
            x++;
            indx1++;

        }
        while (indx2 <= enIndx) {
            merged[x] = arr[indx2];
            x++;
            indx2++;
        }
        for (int i = 0, j = stIndx; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int arr[], int stIndx, int enIndx) {
        if (stIndx >= enIndx) {
            return;

        }
        int mid = stIndx + (enIndx - stIndx) / 2;
        divide(arr, stIndx, mid);
        divide(arr, mid + 1, enIndx);
        Conquer(arr, stIndx, mid, enIndx);

    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8, 1 };
        int n = arr.length;

        divide(arr, 0, n - 1);
        // print array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
