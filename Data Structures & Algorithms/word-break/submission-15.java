// tabulation

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        int sLen = s.length();

        for (String str: wordDict) {
            if (sLen - str.length() >= 0 
                && str.equals(s.substring(sLen - str.length(), sLen))) {
                dp[sLen - str.length()] = true;
            }
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (String str: wordDict) {
                int len = str.length();
                if (i - len >= 0 
                    && str.equals(s.substring(i - len, i)) && dp[i]) {
                    dp[i - len] = true;
                }
            }
        }

        return dp[0];
    }
}
