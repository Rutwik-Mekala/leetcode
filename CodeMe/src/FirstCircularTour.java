import java.util.Deque;
import java.util.LinkedList;

public class FirstCircularTour {

    public static void main(String[] args) {
        int[] petrol = {50,10,60,100};
        int[] distance = {30,20,100,10};
        int ans = fulltour(petrol,distance,petrol.length);
        System.out.println(ans);
    }
    static int fulltour(int[] petrol, int[] distance, int n){
        int start=0;
        int curr_pet=0,prev_pet=0;
        for(int i=0; i<n; i++){
            curr_pet+=(petrol[i]-distance[i]);
            if(curr_pet<0){
                start = i+1;
                prev_pet+=curr_pet;
                curr_pet=0;
            }
        }
        return (curr_pet+prev_pet>=0) ? (start+1) : -1;
    }
}
