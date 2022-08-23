import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {8,18,10,30,12,15}; //18 30 30 -1 15 -1
        System.out.println(printNextG(arr,arr.length));
    }
    public static ArrayList<Integer> printNextG(int[] arr, int n){
        ArrayList<Integer> ar = new ArrayList<>();
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(arr[n-1]);
        ar.add(-1);
        for(int i=n-2; i>=0; i--){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            int next = s.isEmpty() ? -1 : s.peek();
            ar.add(next);
            s.push(arr[i]);
        }
        Collections.reverse(ar);
        return ar;
    }
}
