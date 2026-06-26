public class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0;
        int resLen = 0;
        int n = s.length();
        boolean[][] memo = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || memo[i + 1][j - 1])) {
                        memo[i][j] = true;

                        if (j - i + 1 > resLen) {
                            resIdx = i;
                            resLen = j - i + 1;
                        }
                    }
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }
}