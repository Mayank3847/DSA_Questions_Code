import java.util.PriorityQueue;

public class BinarySearch_Minimize_Maximize_Distance_BetweenGasStation {

    public static double minimizeMaxDistance(int arr[], int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        for (int gS = 1; gS <= k; gS++) {
            double maxSection = -1;
            int maxIndex = -1;
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double) (howMany[i] + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxIndex = i;
                }

            }
            howMany[maxIndex]++;
        }
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double) (howMany[i] + 1);

            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }

    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;

        }
    }

    public static double minimizeMaxDistanceBetter(int arr[], int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));

        }
        for (int gS = 1; gS <= k; gS++) {
            Pair tq = pq.poll();
            int secIndex = tq.second;
            howMany[secIndex]++;
            double diff = arr[secIndex + 1] - arr[secIndex];
            double sectionLength = diff / (double) (arr[secIndex] + 1);
            pq.add(new Pair(sectionLength, secIndex));

        }
        return pq.peek().first;

    }

    public static int numberOfGasStationReq(double dist, int arr[]) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

    public static double minimizeMaxDistanceOptimal(int arr[], int k) {
        int n = arr.length;
        double low = 0, high = 0;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double) (arr[i + 1] - arr[i]));

        }
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationReq(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {

                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        double ans = minimizeMaxDistance(arr, k);
        System.out.println("The answer is: " + ans);
        double ans1 = minimizeMaxDistance(arr, k);
        System.out.println("The answer(Better Approach) is: " + ans1);
        double ans2 = minimizeMaxDistanceOptimal(arr, k);
        System.out.println("The answer(Optimal Approach) is: " + ans2);
    }
}