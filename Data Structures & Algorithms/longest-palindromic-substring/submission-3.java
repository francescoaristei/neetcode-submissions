// brute force

class Solution {
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        // generate all substrings
        Set<String> subs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                subs.add(s.substring(i, j + 1));
            }
        }
        String res = "";
        // check if they are palindromes and retain the longest
        for (String str: subs) {
            if (isPalindrome(str) && str.length() > res.length()) {
                res = str;
            }
        }
        return res;
    }
}
