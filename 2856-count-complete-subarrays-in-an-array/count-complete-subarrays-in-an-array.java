class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // A map to count the unique numbers in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Initialize the map with the unique numbers in the array
        for (int num : nums) {
            frequencyMap.put(num, 1);
        }

        // Store the size of the unique elements in the array
        int uniqueCount = frequencyMap.size();
        // Variable to hold the final result
        int answer = 0;
        // Length of the nums array
        int arrayLength = nums.length;

        // Clear the map for reuse
        frequencyMap.clear();

        // Sliding window approach
        for (int left = 0, right = 0; right < arrayLength; ++right) {
            // Add or update the count of the current element
            frequencyMap.merge(nums[right], 1, Integer::sum);
            // If the window contains all unique elements
            while (frequencyMap.size() == uniqueCount) {
                // Update the answer with the number of subarrays ending with nums[right]
                answer += arrayLength - right;
                // Move the left pointer, decrementing the frequency of the left-most element
                if (frequencyMap.merge(nums[left], -1, Integer::sum) == 0) {
                    // If the count goes to zero, remove the element from the map
                    frequencyMap.remove(nums[left]);
                }
                ++left;
            }
        }

        // Return the total count of complete subarrays
        return answer;
    }
}