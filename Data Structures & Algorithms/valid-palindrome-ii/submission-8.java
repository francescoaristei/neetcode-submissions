// radkar
// acdccba

class Solution {

    private boolean isValidPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isValidPalindrome(s.substring(l + 1, r + 1)) || isValidPalindrome(s.substring(l, r));
            }
            l++;
            r--;
        }
        return true;
    }
}