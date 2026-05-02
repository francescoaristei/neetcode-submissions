/*
* Brute force solution: Sort the two strings and then compare the contents
* of the two strings, if they are the same it means that the original strings
* were anagrams of each other, otherwise they were not.
* Time complexity: Cost of sorting: O(n * log(n) + m * log(m))
* Space complexity: O(1)
*
* Solution with two HashMaps: If the two strings are anagram they have the same
* characters with the same occurrences.
* Create two HashMaps one for each string: HashMap<Character, Integer>.
* Key: characters of the string.
* Value: count of that character in the string (initial value of 0).
* Iterate through each string and increment the value for each key.
* If the strings are anagrams, the two HashMaps will be equal.
* Time complexity: O(n + m).
* Space complexity: O(1) because you can have at least 26 keys in the HashMaps.
*
* Solution with fixed size array: Create an array of 26 chars (english letters).
* Given the chars of each string, by subtracting the value of 'a' from it, given
* the ASCII codes associated to the characters, you obtain a value between 0 and 25.
* Therefore, iterate through first string and for each char increment by 1 the value of
* the fixed size array created at position s.charAt(i) - 'a'.
* Iterate through the second string and for each char decrement by 1 the value of
* the fixed size array created at position t.charAt(j) - 'a'.
* If the two strings are anagram, you expect the fixed size array to have each cell
* with value 0.
* Time complexity: O(n + m)
* Space complexity: O(1)
*
* Edge case you did not consider: if the two strings have different sizes, just return
* false, they cannot be anagrams.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        // Java automatically initializes with 0's primitive numeric type arrays
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] += 1;
        }
        for (int j = 0; j < t.length(); j++) {
            letters[t.charAt(j) - 'a'] -= 1;
        }
        for (int l = 0; l < letters.length; l++) {
            if (letters[l] != 0) {
                return false;
            }
        }
        return true;
    }
}
