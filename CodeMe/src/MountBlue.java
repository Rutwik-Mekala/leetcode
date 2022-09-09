//mountblue coding interview solutions
import java.util.*;
public class MountBlue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getAnswer1(n);

        String[] arr = {"RED","BLUE","GREEN"};
        getAnswer2(arr);
    }
    /*Print output like this for input n
    Here n=4 o/p
    1 1 1 1 1 1 1
    2 2 2 2 2
    3 3 3
    4
    3 3 3
    2 2 2 2 2
    1 1 1 1 1 1 1

     */
    public static void getAnswer1(int n){
        int track = 1;
        boolean hit = false;
        for(int i = n; i<2*n-(n-1); ){
            for(int j=0; j<2*i-1; j++){
                System.out.print(track+" ");
            }
            System.out.println();
            if(i>1 && !hit){
                i--;
                track++;
            }else if(i==1){
                hit = true;
            }
            if(hit){
                i++;
                track--;
            }
        }
    }
    /*
    Print String elements vertically
    Example:
    R B G
    E L R
    D U E
      E E
        N
    */
    public static void getAnswer2(String[] arr){
        int m = 0;
        for(int i=0; i<arr.length; i++){
            m = Math.max(m,arr[i].length());
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<arr.length; j++){
                if(i<arr[j].length()){
                    System.out.print(arr[j].charAt(i)+" ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
