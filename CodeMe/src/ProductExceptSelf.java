public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        for(int i: productExceptSelf(arr)){
            System.out.print(i+" ");
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int left = 1, right = 1;
        for(int i=0; i<nums.length; i++){
            arr[i] = left;
            left*=nums[i];
        }
        for(int i=nums.length-1; i>=0; i--){
            arr[i] *= right;
            right*=nums[i];
        }
        return arr;
    }
}
