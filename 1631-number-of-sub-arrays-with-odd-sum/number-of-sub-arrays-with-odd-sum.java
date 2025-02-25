class Solution {
    // Method to calculate the number of subarrays with odd sum
    public int numOfSubarrays(int[] arr) {
        // Initialize the modulus value as per the problem statement
        final int MOD = 1000000007;
      
        // Counter array to track even and odd sums, where index 0 is for even and index 1 is for odd
        int[] count = {1, 0};
      
        // Variable to store the final answer
        int answer = 0;
      
        // Variable to store the current sum
        int sum = 0;
      
        // Iterate through each element in the array
        for (int num : arr) {
            // Add the current element's value to the cumulative sum
            sum += num;
          
            // If the cumulative sum is odd, add the count of previous even sums to the answer.
            // If the cumulative sum is even, add the count of previous odd sums to the answer.
            // Then, take the modulo to handle large numbers
            answer = (answer + count[1 - (sum & 1)]) % MOD;
          
            // Increment the count of current parity (even/odd) of sum
            ++count[sum & 1];
        }
      
        // Return the final answer
        return answer;
    }
}