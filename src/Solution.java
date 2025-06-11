import java.util.*;

public class Solution {

    public static List<List<Integer>> findSumPairs(
            int[] numbers,
            int target) {
        Set<Integer> seen = new HashSet<>();
        Set<List<Integer>> res = new HashSet<>();

        for (int num : numbers) {
            int complement = target - num;
            if (seen.contains(complement)) {
                List<Integer> pair =
                        Arrays.asList(
                                Math.min(num, complement),
                                Math.max(num, complement));
                res.add(pair);
            }
            seen.add(num);
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 4, 3, 7, 1, 5};
        int target = 6;

        List<List<Integer>> pairs = Solution.findSumPairs(nums, target);
        for (List<Integer> pair : pairs) {
            System.out.println(
                    "Pair found : " + pair.get(0) + " and " + pair.get(1) );
        }
    }
}