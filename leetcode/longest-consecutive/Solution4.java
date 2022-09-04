import java.util.HashMap;

/* Not hashmpa was quicker than hashset */
class Solution4 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> num_set = new HashMap<>();
        for (int num : nums) {
            num_set.put(num, num);
        }

        int longestStreak = 0;

        for (int num : num_set.keySet()) {
            if (num_set.get(num-1)==null) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.get(currentNum+1)!=null) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}