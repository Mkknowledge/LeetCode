class Solution {
    public int minSwaps(String s) {
        int imbalance = 0; // This variable will keep the count of current imbalance
        int swaps = 0; // This variable will keep the total number of swaps needed

        // Iterate through each character in the input string
        for (char bracket : s.toCharArray()) {
            if (bracket == '[') {
                // An opening bracket decreases the imbalance
                imbalance++;
            } else if (imbalance > 0) { // It's a closing bracket and we have an imbalance
                // A closing bracket opposite to an opening one balances out,
                // so decrease the current imbalance
                imbalance--;
            }
        }

        // The number of extra opening brackets is divided by 2 to get the number of swaps,
        // because each swap will fix two misplaced brackets.
        // If the number of imbalances is odd, it's divided by 2 and then rounded up.
        // The rightward shift operation (imbalance + 1) >> 1 is effectively dividing by 2
        // and rounding up in case of an odd number.
        swaps = (imbalance + 1) >> 1;

        return swaps;
    }

}