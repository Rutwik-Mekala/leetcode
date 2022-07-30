//leetcode 217
import java.util.*;
class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(answer2(nums));
    }
    public static boolean answer1(int[] nums){
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]) return true;
        }
        return false;
    }
    public static boolean answer2(int[] nums){
        HashSet<Integer> s = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(s.contains(nums[i])) return true;
            s.add(nums[i]);
        }
        return false;
    }
}
