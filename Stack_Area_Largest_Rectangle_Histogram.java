import java.util.*;

public class Stack_Area_Largest_Rectangle_Histogram {
    public static int areaLargestRectangle(int height[]) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, height[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }



    public static int areaLargestRectangleOptimized1(int height[]){
        int n =height.length;
        int maxArea=0;
        Stack<Integer>st=new Stack<>();
        for(int i =0;i<=n;i++){
            while(!st.isEmpty()&&(i==n||height[st.peek()]>height[i])){
                int ht=height[st.peek()];
                st.pop(); 
                int wt;
                if(st.isEmpty()){
                    wt=i;
                }
                else{
                    wt=i-st.peek()-1;
                }
                maxArea=Math.max(maxArea,  ht * wt);

            }
            st.push(i);
        }
        return maxArea;

    }
    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3, 1 };
        System.out.println("The largest area in the histogram is :   " + areaLargestRectangle(arr));
        System.out.println("The largest area in the histogram (Optimized 1) is :   " + areaLargestRectangleOptimized1(arr));


    }

}
