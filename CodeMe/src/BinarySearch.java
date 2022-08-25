public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10,15,25};
        int x = 15;
        System.out.println(binarySearchRecursive(arr,x,0,arr.length-1));
    }
    public static int binarySearchIterative(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]>x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    public static int binarySearchRecursive(int[] arr, int x, int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]>x){
                return binarySearchRecursive(arr,x,low,mid-1);
            }else{
                return binarySearchRecursive(arr,x,mid+1,high);
            }
        }
        return -1;
    }
}
