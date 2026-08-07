class Solution {
    private List<List<String>> result = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void rec(String s, int start, int end) {
        if (end >= s.length()) {
            if (start == end) {
                List<String> temp = new ArrayList<>(list);
                result.add(temp);
            }
            return;
        }

        if (isPalindrome(s, start, end)) {
            list.add(s.substring(start, end + 1));
            rec(s, end + 1, end + 1);
            list.remove(list.size() - 1);
        }

        rec(s, start, end + 1);
    }

    public List<List<String>> partition(String s) {
        rec(s, 0, 0);
        return result;
    }
}
