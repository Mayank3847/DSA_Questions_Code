public class trappedwater_array {
    public static int trappedRainWater(int height[], int width) {
        int n = height.length;
        // calculate left maximum boundary
        int leftmaxBoundary[] = new int[n];
        leftmaxBoundary[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmaxBoundary[i] = Math.max(height[i], leftmaxBoundary[i - 1]);
        }
        // calculate right max boundary
        int rightMaxBoundary[] = new int[n];
        rightMaxBoundary[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxBoundary[i] = Math.max(height[i], rightMaxBoundary[i + 1]);

        }
        int trappedwater = 0;
        // loop
        // water level=minimum(leftmaximum boundary,right max boundary)
        for (int i = 0; i < n; i++) {
            // to find the water level
            int waterLevel = Math.min(leftmaxBoundary[i], rightMaxBoundary[i]);
            // trapped water=====(Water level-height)*width
            trappedwater += (waterLevel - height[i]) * width;

        }
        return trappedwater;
    }

    public static int trappedRainWaterOptimized(int height[]) {
        int left = 0;
        int n = height.length;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];

                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];

                } else {
                    res += rightMax - height[right];
                }
                right--;
            }

        }

        return res;

        
    }

    public static void main(String[] args) {
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int width = 1;
        System.out.println(trappedRainWater(height, width));
        System.out.println(trappedRainWaterOptimized(height));
    }

}
