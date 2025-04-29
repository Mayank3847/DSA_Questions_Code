public class BitManipulation_MaximumXOR_Array {

    public static int maximumXor(int arr[]){
        int maxi=0;
        for(int i =0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                maxi=Math.max(maxi,arr[i]^arr[j]);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR : " + maximumXor(arr));
   
    }
}