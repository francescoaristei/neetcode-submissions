class Solution {
    private List<String> result = new ArrayList<>();
    private StringBuilder str = new StringBuilder();

    private void rec(int n, int open, int closed) {
        if (str.length() == 2 * n) {
            result.add(str.toString());
            return;
        }

        if (open < n) {
            str.append('(');
            rec(n, open + 1, closed);
            str.deleteCharAt(str.length() - 1);
        }

        if (closed < open) {
            str.append(')');
            rec(n, open, closed + 1);
            str.deleteCharAt(str.length() - 1);
        }

    }

    public List<String> generateParenthesis(int n) {
        int open = 0;
        int closed = 0;
        rec(n, open, closed);
        return result;
    }
}
