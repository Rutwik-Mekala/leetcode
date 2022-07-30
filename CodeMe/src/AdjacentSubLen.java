import java.util.*;

public class AdjacentSubLen {
    //IP:
    //First line size ofarray
    //From second line N inputs of array

    //OP-Max number of elements in subarray which satisfy the given condition

    //Condition:
    //[1,2,3,2,3,4,2,1]
    // Arr(i)-Arr(i+1)<=+-1;
    //Max element of subarray-Min element of subarray<=+-1;

    //Example:

    //[1,1,2,2,1,3]>[1,1,2,2,1]
    //OP-5;
    //[3,4,1,2,1,1,2,3,2,1,5]
    //OP-5
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input size of arraylist");
        int N = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            System.out.println("Enter val "+i);
            int num = Integer.parseInt(sc.nextLine());
            list.add(num);
        }
        System.out.println(getAnswer2(list,N));
    }
    public static int getAnswer2(ArrayList<Integer> list, int N){
        HashSet<Integer> s = new HashSet<>();
        s.add(-1);
        s.add(0);
        s.add(1);
        int min = list.get(0);
        int max = list.get(0);
        int count = 1;
        int res = 0;
        for(int i=0; i<N; i++){
            if(list.get(i)<min) min = list.get(i);
            if(list.get(i)>max) max = list.get(i);
            if(s.contains(max-min) && s.contains(list.get(i)-list.get(i+1))){
                count++;
            }else{
                count = 1;
                min = list.get(i);
                max = list.get(i);
            }
            res = Math.max(res,count);
        }
        return res;
    }

}
