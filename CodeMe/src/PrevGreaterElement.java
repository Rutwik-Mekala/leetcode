import java.util.ArrayDeque;

public class PrevGreaterElement {
    public static void main(String[] args) {
        int[] arr = {20,30,10,5,15};
        printPrevG(arr,arr.length);
    }
    public static void printPrevG(int[] arr, int n){
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(arr[0]);
        System.out.print(-1+" ");
        for(int i=1; i<n; i++){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            int prev = s.isEmpty() ? -1 : s.peek();
            System.out.print(prev+" ");
            s.push(arr[i]);
        }
    }
}
