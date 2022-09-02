public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {5,60,50,30,20,50,60};
        System.out.println(peak(arr));
    }
    public static int peak(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid]))
                return mid;
            if(mid>0 && arr[mid-1]>=arr[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}
