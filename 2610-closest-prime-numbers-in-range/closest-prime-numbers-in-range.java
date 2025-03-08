class Solution {
     // Function to find the two closest primes within a given range [left, right]
    public int[] closestPrimes(int left, int right) {
        // Counter for the number of primes found
        int primeCount = 0;
        // Boolean array to mark non-prime numbers (sieve)
        boolean[] sieve = new boolean[right + 1];
        // Array to store prime numbers
        int[] primes = new int[right + 1];

        // Sieve of Eratosthenes to find all primes up to 'right'
        for (int i = 2; i <= right; ++i) {
            if (!sieve[i]) {
                // If the number is prime, add it to the list of primes
                primes[primeCount++] = i;
            }
            // Mark multiples of prime[i] as non-prime
            for (int j = 0; primes[j] <= right / i; ++j) {
                sieve[primes[j] * i] = true;
                // If 'i' is a multiple of prime[j], break to maintain the sieve property
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }

        // Indices for tracking the closest pair of primes
        int firstPrimeIndex = -1, secondPrimeIndex = -1;
        // Find the range of indices for primes within [left, right]
        for (int k = 0; k < primeCount; ++k) {
            if (primes[k] >= left && primes[k] <= right) {
                if (firstPrimeIndex == -1) {
                    firstPrimeIndex = k;
                }
                secondPrimeIndex = k;
            }
        }

        // Array to store the result
        int[] result = new int[] {-1, -1};
        // If there are not two different primes or no primes at all, return the default result
        if (firstPrimeIndex == secondPrimeIndex || firstPrimeIndex == -1) {
            return result;
        }

        // Initialize the minimum distance between primes to a large number
        int minDistance = Integer.MAX_VALUE;
        // Iterate through primes within the given range and find the closest pair
        for (int k = firstPrimeIndex; k < secondPrimeIndex; ++k) {
            int distance = primes[k + 1] - primes[k];
            // Update the closest pair if a smaller distance is found
            if (distance < minDistance) {
                minDistance = distance;
                result[0] = primes[k];
                result[1] = primes[k + 1];
            }
        }

        // Return the closest pair of primes
        return result;
    }
}