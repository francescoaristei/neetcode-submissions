class Solution {
    private Map<Integer, String> digitsToChars = Map.of(
        2, "abc", 3, "def", 4, "ghi", 5, "jkl", 6, "mno",
        7, "pqrs", 8, "tuv", 9, "wxyz"
    );
    private List<String> result = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private void rec(int[] nums, int start, int k) {
        if (sb.length() == k) {
            String temp = new String(sb.toString());
            result.add(temp);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            String chars = digitsToChars.get(nums[i]);
            for (int j = 0; j < chars.length(); j++) {
                sb.append(chars.charAt(j));
                rec(nums, i + 1, k);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return result;
        }
        int k = digits.length();
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = digits.charAt(i) - '0';
        }
        rec(nums, 0, k);
        return result;
    }
}
