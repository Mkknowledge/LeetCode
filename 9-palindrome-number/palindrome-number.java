class Solution {
    public boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        StringBuilder sb = new StringBuilder(value);
        return sb.reverse().toString().equals(value);
    }
}