/*
* - Define two pointers i, j starting at i = 0 and j = 0
* - Define substring initially as s[i] = s[j]
* - Define int result = 1 as at least one character is a valid substring
* - Define HashMap with key the char at position s[j] and value the index j
* - Increment j, check if s[j] is in the HashMap
* - If no, add it to the HashMap, increase result
* - If yes, set i = map[j] and j = i + 1 and continue
*
* Time complexity: O(n)
* Space complexity:
*   - Worst case: the string s has all distinct chars: The hashmap has size n -> O(n)
*   - Average case: O(z * m) with m being the avg size of the substrings and z number of substrings
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int i = 0;
        int result = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        while (j < s.length()) {
            if (charIndexMap.containsKey(s.charAt(j))) {
                i = charIndexMap.get(s.charAt(j)) + 1;
                j = i;
                charIndexMap = new HashMap<>();
                continue;
            }
            charIndexMap.put(s.charAt(j), j);
            int length = j - i + 1;
            if (length > result) {
                result = length;
            }
            j++;
        }
        return result;
    }
}
