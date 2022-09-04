import java.util.Arrays;
/* Results
 * Runtime: 12 ms, faster than 99.73% of Java online submissions for Longest Consecutive Sequence.
Memory Usage: 51.9 MB, less than 98.67% of Java online submissions for Longest Consecutive Sequence.
 */
class Solution1 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        Arrays.sort(nums);
        int maxLen=1;
        int last=nums[0];
        int len = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==last+1)
                len++;
            else if (nums[i]==last); // Do noting ?? To meet example3
            else
                len=1;
            last = nums[i];
            if(len>maxLen)
                maxLen=len;
        }
        return maxLen;
    }
}