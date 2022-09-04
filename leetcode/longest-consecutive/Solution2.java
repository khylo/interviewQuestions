import java.util.HashSet;

/* no sort,. map only
 */
class Solution2 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        HashSet<Integer> set = new HashSet<>(nums.length);    
        int maxLen=1;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(Integer i: set){
            if(!set.contains(i-1)){
                int currLen = 1;
                while(set.contains(i+1)){
                    currLen++;
                    i++;
                }
                maxLen=max(maxLen, currLen);
            }
        }
        return maxLen;
    }

    public int max(int a, int b){
        if(a>b)
            return a;
        return b;
    }
}