public class ST_MinimumElementQueries {

    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];

    }

    // si=starting range of sum of subarray
    // sj=ending range of sum of subarray
    // qi=index from we have to calculate or do operation on query
    // qj=last index from we have to calculate or do operation on query
    public static void buildST(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }
        int mid = (si + sj) / 2;
        buildST(2 * i + 1, si, mid, arr);
        buildST(2 * i + 2, mid + 1, sj, arr);
        tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);

    }

    public static int getMinUtil(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMin(0, 0, n - 1, qi, qj);
    }

    public static int getMin(int i, int si, int sj, int qi, int qj) {
        // case1 -no overlapping
        if (sj < qi || si > qj) {
            return Integer.MAX_VALUE;
            // case 2-------complete overlapping
        } else if (si >= sj && sj <= qj) {
            return tree[i];
            // partially overlapping
        } else {
            int mid = (si + sj) / 2;
            int leftAns = getMin(2 * i + 1, si, mid, qi, qj);
            int rightAns = getMin(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.min(leftAns, rightAns);
        }
    }

    public static void update(int arr[], int index, int newVal) {
        arr[index] = newVal;
        int n = arr.length;
        updateUtil(0, 0, n - 1, index, newVal);

    }

    public static void updateUtil(int i, int si, int sj, int index, int newVal) {
        if (index < si || index > sj) {
            return;
        }
        if (si == sj) {
            tree[i] = newVal;
        }
        if (si != sj) {
            tree[i] = Math.min(tree[i], newVal);
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, index, newVal);
            updateUtil(2 * i + 2, mid + 1, sj, index, newVal);

        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        init(n);
        buildST(0, 0, n - 1, arr);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        int result = getMinUtil(arr, 2, 5);
        System.out.println();
        System.out.println("MINIMUM -> " + result);

        update(arr, 2, 20);
        result = getMinUtil(arr, 2, 5);// ---->means than get maximum of element of array from index-2 to index-5
        System.out.println("After Updatation Minimum -> " + result);

    }

}