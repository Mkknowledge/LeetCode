class Solution {
    public List<String> stringMatching(String[] words) {
         // Initialize an empty list to hold the answer
        List<String> matchedStrings = new ArrayList<>();
        // Get the number of words in the array
        int numberOfWords = words.length;
      
        // Iterate through each word in the array
        for (int i = 0; i < numberOfWords; ++i) {
            // Inner loop to compare the current word with others
            for (int j = 0; j < numberOfWords; ++j) {
                // Check if words are different and if the current word is contained within another word
                if (i != j && words[j].contains(words[i])) {
                    // If the condition is true, add the current word to the list of matched strings
                    matchedStrings.add(words[i]);
                    // Break out of the inner loop, as we already found a matching word
                    break;
                }
            }
        }
        // Return the list of matched strings
        return matchedStrings;
    }
}