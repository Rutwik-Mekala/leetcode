import java.util.ArrayDeque;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {18,12,13,14,11,16};
        printSpan(arr,arr.length);
    }
    public static void printSpan(int[] arr, int n){
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(0);
        System.out.print(1+" ");
        for(int i=1; i<n; i++){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            int span = s.isEmpty() ? i+1 : i-s.peek();
            System.out.print(span+" ");
            s.push(i);
        }
    }
}
