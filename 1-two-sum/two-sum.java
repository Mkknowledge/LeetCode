class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
       int[] arr = IntStream.range(0, nums.length)
       .filter(index -> {
        if(map.containsKey(nums[index])) {
            return true;
        } else {
            map.put(target - nums[index], index);
            return false;
        }
       })
       .mapToObj(index -> new int[]{map.get(nums[index]), index})
       .findFirst()
       .orElse(new int[2]);
       return arr;
    }
}