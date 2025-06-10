//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Solution {

    public List<int[]> allTwoSums(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result.add(new int[]{map.get(complement), i});
            }
            // Update map after checking to avoid duplicate use of the same index
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 7, 11, 15, 1, 8};
        int target = 9;

        List<int[]> pairs = sol.allTwoSums(nums, target);
        for (int[] pair : pairs) {
            System.out.println("Pair found at indices: " + pair[0] + " and " + pair[1] +
                    " (values: " + nums[pair[0]] + ", " + nums[pair[1]] + ")");
        }
    }
}