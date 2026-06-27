// memoization

class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    private int rec(String s) {
        if (s.length() > 0 && s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() <= 1) {
            return 1;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if ((s.charAt(0) == '1') || (s.charAt(0) == '2' && s.charAt(1) < '7')) {
            String sub1 = s.substring(1, s.length());
            String sub2 = s.substring(2, s.length());

            memo.put(sub1, rec(sub1));
            memo.put(sub2, rec(sub2));

            return memo.get(sub1) + memo.get(sub2);
        } else {
            String sub = s.substring(1, s.length());
            memo.put(sub, rec(sub));

            return memo.get(sub);
        }
    }


    public int numDecodings(String s) {
        return rec(s);
    }
}
