import java.util.ArrayDeque;


public class LargestHistogramArea {
    public static void main(String[] args) {
        int[] arr = {6,2,5,4,1,5,6};
        System.out.println(largestHistogramArea(arr,arr.length));
    }
    public static int largestHistogramArea(int[] arr, int n){
        int[] ps = prevSmaller(arr,n);
        int[] ns = nextSmaller(arr,n);
        int res = 0;
        for(int i=0; i<n; i++){
            int curr = arr[i];
            curr+= (i-ps[i]-1)*arr[i];
            curr+= (ns[i]-i-1)*arr[i];
            res = Math.max(res,curr);
        }
        return res;
    }
    public static int[] prevSmaller(int[] arr, int n){
        int[] ar = new int[n];
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(0);
        ar[0] = -1;
        for(int i=1; i<n; i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            int prev = s.isEmpty() ? -1 : s.peek();
            ar[i] = prev;
            s.push(i);
        }
        return ar;
    }
    public static int[] nextSmaller(int[] arr, int n){
        int[] ar = new int[n];
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(n-1);
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            int next = s.isEmpty() ? n : s.peek();
            ar[i] = next;
            s.push(i);
        }

        return ar;
    }
}
