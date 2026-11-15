class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    private Set<String> strings = new HashSet<>();

    private int rec(String s, int start) {
        if (start >= s.length()) {
            return 0;
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        memo.put(start, s.length() - start);

        for (int i = start; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (strings.contains(s.substring(i, j))) {
                    memo.put(start, Math.min(memo.get(start), i - start + rec(s, j)));
                }
            }
        }
        return memo.get(start);
    }

    public int minExtraChar(String s, String[] dictionary) {
        for (String dictString: dictionary) {
            strings.add(dictString);
        }
        return rec(s, 0);
    }
}