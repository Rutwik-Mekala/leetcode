//greedy algorithm job sequencing question solved
import java.util.Arrays;

public class JobSequence {
    static class Job implements Comparable<Job>{
        int deadline;
        int profit;
        Job(int d, int p){
            deadline = d;
            profit = p;
        }
        public int compareTo(Job j){
            return j.profit - this.profit;
        }
    }
    public static void main(String[] args) {
        Job[] arr = {new Job(2,100),new Job(1,50),new Job(2,10),new Job(1,20),new Job(3,30)};
        //JobSequencing(arr);
        printArray(JobSequencing(arr));
    }
    public static int[] JobSequencing(Job[] arr){
        Arrays.sort(arr);
        boolean[] slot = new boolean[arr.length];
        Arrays.fill(slot,false);
        int res = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            int idx = arr[i].deadline-1;
            if(!slot[idx]) {
                slot[idx] = true;
                res+=arr[i].profit;
                count++;
            }else{
                while(idx>0){
                    if(!slot[idx]) {
                        slot[idx] = true;
                        res += arr[i].profit;
                        count++;
                        break;
                    }else{
                        idx--;
                    }
                }
            }
        }
        return new int[]{count,res};
    }
    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
