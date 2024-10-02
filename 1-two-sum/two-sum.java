class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapOfElement = new HashMap<>();
        int[] arr = IntStream.range(0, nums.length)
        .filter(index -> {
            if (mapOfElement.containsKey(nums[index])) {
                return true;
            } else {
                mapOfElement.put(target - nums[index], index);
                return false;
            }
        })
        .mapToObj(index -> new int[]{mapOfElement.get(nums[index]), index})
        .findFirst()
        .orElse(new int[2]);
        return arr;
    }
}