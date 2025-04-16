public class BinarySearch_PartitonPainter {
    public static int canWePaint(int arr[], int paints) {
        int n = arr.length;
        int partiton = 1;
        int currPartition = 0;
        for (int i = 0; i < n; i++) {
            if (currPartition + arr[i] <= paints) {
                currPartition += arr[i];
            } else {
                currPartition = arr[i];
                partiton++;
            }
        }
        return partiton;
    }

    public static int paintPartition(int arr[], int k) {
        int n = arr.length;

        int low = arr[0];
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(arr[i], low);
            high += arr[i];
        }
        for (int i = low; i <= high; i++) {
            if (canWePaint(arr, i) == k) {
                return i;
            }
        }
        return low;
    }

    public static int paintPartitionOptimal(int arr[], int k) {
        int low = arr[0];
        int high = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            high += arr[i];
            low = Math.max(low, arr[i]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePaint(arr, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40 };
        int k = 2;
        int ans = paintPartition(arr, k);
        System.out.println("Painter's Partition Problem : " + ans);
        int ans1 = paintPartitionOptimal(arr, k);
        System.out.println("Painter's Partition Problem : " + ans1);
   
    }

}
