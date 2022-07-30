//leetcode 1
import java.util.*;

class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        for (int i : answer(nums, target)) {
            System.out.print(i + " ");
        }
    }
    public static int[] answer(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(target - nums[i])) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] neetcodeSolution(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (prevMap.containsKey(nums[i])) {
                return new int[]{prevMap.get(num), i};
            }
            prevMap.put(target - num, i);
        }
        return new int[]{};
    }
}
