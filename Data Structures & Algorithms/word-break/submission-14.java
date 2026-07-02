// memoization
// 

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
                if (rec(s.substring(w.length(), s.length()), wordDict)) {
                    memo.put(w, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return rec(s, wordDict);
    }
}
