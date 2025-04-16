public class Array_MoveZeroToEnd {
    public static int [] moveZero(int arr[]){
        int n =arr.length;
        int index=0;
        int result[]=new int [n];
        for(int i =0;i<n;i++){
            if(arr[i]!=0){
                result[index]=arr[i];
                index++;
            }
        }
        return result;
    }



    //for Optimal solution 
    public static void moveZeroOptimal(int arr[]){
        int n =arr.length;
        int index=0;
        for(int i =0;i<n;i++){
            if(arr[i]!=0){
                arr[index]=arr[i];
                index++;
            }
        }
        for(int i=index;i<n;i++){
            arr[i]=0;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,0,2,3,0,4,0,1};
        
        int result[]=moveZero(arr);
        for(int i =0;i<arr.length;i++){

            System.out.print(result[i]+" ");
        }
        System.out.println();
        arr=new int[]{1,3,2,3,0,4,0,1};
        moveZeroOptimal(arr);
        System.out.println("Optimal Answer -> ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
}
