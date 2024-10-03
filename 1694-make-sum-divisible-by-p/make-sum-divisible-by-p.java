class Solution {
    public int minSubarray(int[] nums, int p) {
        int reqRem = 0;
        for(int i:nums) reqRem = (reqRem+i)%p;
        if(reqRem ==0) return 0;
        Map<Integer, Integer> rems = new HashMap<>();
        rems.put(0, -1);
        int ans = nums.length, rem = 0;
        for(int i =0; i<nums.length; i++) {
            rem = (rem+nums[i])%p;
            int target = (rem - reqRem+p)%p;
            if(rems.containsKey(target)) {
                ans = Math.min(ans, i - rems.get(target));
            }
            rems.put(rem, i);
        }
        return ans == nums.length?-1:ans;
    }
}