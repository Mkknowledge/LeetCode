class Solution {
    public List<String> wordSubsets(String[] universalSet, String[] subsetWords) {
        // This array will keep the max frequency of each letter required by subsetWords
        int[] maxSubsetFreq = new int[26];
      
        // Calculate the max frequency of each character across all words in subsetWords
        for (String subsetWord : subsetWords) {
            // Temporary array to store frequency of each character in the current word
            int[] tempFreq = new int[26];
            for (char ch : subsetWord.toCharArray()) {
                // Increment character frequency
                tempFreq[ch - 'a']++;
              
                // Update the maxSubsetFreq array with the maximum frequency needed for this character
                maxSubsetFreq[ch - 'a'] = Math.max(maxSubsetFreq[ch - 'a'], tempFreq[ch - 'a']);
            }
        }
      
        // This will store our final result
        List<String> result = new ArrayList<>();
      
        // Loop through each word in universalSet
        for (String word : universalSet) {
            // Temporary array to store frequency of each character in the current word
            int[] wordFreq = new int[26];
            for (char ch : word.toCharArray()) {
                // Increment character frequency
                wordFreq[ch - 'a']++;
            }
          
            // Check if the current word contains all the required characters in proper frequency 
            boolean isUniversal = true;
            for (int i = 0; i < 26; ++i) {
                if (maxSubsetFreq[i] > wordFreq[i]) {
                    // If any character is found in less frequency than required, 
                    // mark word as non-universal, and break the loop
                    isUniversal = false;
                    break;
                }
            }
          
            // If the word is universal, add it to the result list
            if (isUniversal) {
                result.add(word);
            }
        }
      
        // Return the list of all universal words
        return result;
    }
}