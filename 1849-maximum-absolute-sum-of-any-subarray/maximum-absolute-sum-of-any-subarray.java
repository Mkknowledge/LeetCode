class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEndingHere = 0; // Represents the maximum subarray sum ending at the current position
        int minEndingHere = 0; // Represents the minimum subarray sum ending at the current position
        int maxAbsoluteSum = 0; // Keeps track of the maximum absolute subarray sum

        // Traverse the array
        for (int num : nums) {
            // Calculate the maximum subarray sum ending here by taking the maximum of
            // the current maximum subarray sum (extended by the current number) and 0
            maxEndingHere = Math.max(maxEndingHere + num, 0);

            // Calculate the minimum subarray sum ending here by taking the minimum of
            // the current minimum subarray sum (extended by the current number) and 0
            minEndingHere = Math.min(minEndingHere + num, 0);

            // Calculate the current maximum absolute subarray sum by taking the maximum of
            // the current maximum absolute sum, the current maximum subarray sum ending here,
            // and the absolute value of the current minimum subarray sum ending here
            maxAbsoluteSum = Math.max(maxAbsoluteSum, Math.max(maxEndingHere, Math.abs(minEndingHere)));
        }

        // Return the overall maximum absolute subarray sum found
        return maxAbsoluteSum;
    }
}