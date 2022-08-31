public class SquareRoot {
    public static void main(String[] args) {
        int x = 15;
        System.out.println(squareRootFloor(x));
    }
    public static int squareRootFloor(int x){
        int low = 1, high = x, ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            int midSQ = mid*mid;
            if(midSQ==x){
                return mid;
            }else if(midSQ>x){
                high = mid-1;
            }else{
                low = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
}
