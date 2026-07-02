// memoization

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    private boolean rec(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        boolean res = false;
        for (String w: wordDict) {
            if (w.length() <= s.length() &&
                w.equals(s.substring(0, w.length()))) {
                res = rec(s.substring(w.length(), s.length()), wordDict);
            }
            if (res) {
                memo.put(s, res);
                return true;
            }
        }
        memo.put(s, res);
        return memo.get(s);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return rec(s, wordDict);
    }
}
