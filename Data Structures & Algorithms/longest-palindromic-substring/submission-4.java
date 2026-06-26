// dp

class Solution {
    // false values by default

    private boolean isPalindrome(int i, int j, String s, boolean[][] memo) {
        while (i < j) {
            if (memo[i][j]) {
                return true;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        memo[i][j] = true;
        return true;
    }
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String res = "";
        boolean[][] memo = new boolean[s.length()][s.length()];


        // generate all substrings
        Set<String> subs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(i, j, s, memo) && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
