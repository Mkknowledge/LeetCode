class Solution {

    // This method is designed to distribute candies among three children with a certain limit
    public long distributeCandies(int candies, int limit) {
      
        // If the candies are more than three times the limit, no valid distribution is possible
        if (candies > 3 * limit) {
            return 0;
        }

        // Calculate the basic number of distributions without limits using combinatorics
        long distributions = combinationOfTwo(candies + 2);

        // Adjust the distribution count by accounting for the limit
        if (candies > limit) {
            distributions -= 3 * combinationOfTwo(candies - limit + 1);
        }

        // Further adjust the distribution if needed when candies are twice over the limit
        if (candies - 2 >= 2 * limit) {
            distributions += 3 * combinationOfTwo(candies - 2 * limit);
        }

        // Return the total number of valid distributions
        return distributions;
    }

    // Helper method to calculate combinations, choosing 2 from n (nC2)
    private long combinationOfTwo(int n) {
        // Use long to avoid integer overflow for large n values
        return 1L * n * (n - 1) / 2;
    }
}
