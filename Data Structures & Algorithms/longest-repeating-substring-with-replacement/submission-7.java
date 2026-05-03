/*
Doubts:
- The characters I decide to substitute have to be consecutive within the string? No
- In a substitution step, the k characters that I want to substitute have to be all the
  same character?
  No
- In which case I don't want to execute the process k time and I want to substitute
  less than k characters? 
  Only when I have obtained a string made of all the same characters before exhausting k?
  As in the example below 
    XYYX k = 3
  Once I have substituted the two Y's or X's once, I already have all X's or Y's
  Or there are other cases as well?
- Do I always start from the longest substring of same characters? 
  No, not necessarily
  In the example below:
    ABBBABBABBBABBBBABFKLAJDNEKAJFKDAKKKLBBBBB k = 2
  The longest substring of same characters is the one at the end of B's, however,
  if you substitute the closer characters with B's two times you obtain:
    ABBBABBABBBABBBBABFKLAJDNEKAJFKDABBBBBBBBB where the substring has length 9
  However, if you substitute the A's in between the B's in the beginning of the
  string you obtain:
    BBBBBBBBBBBBBBBBABFKLAJDNEKAJFKDAKKKLBBBBB where the substring has length 16
- Starting to substitute characters in the string and then realizing that the 
  obtained substring is not the optimal one is not a problem to find the actual
  optimal solution

START OF SOLUTION:

- Define a HashMap (or HashSet) for all the uppercase characters of english alphabet
- For each letter of the HashMap iterate over the characters of the string 
  (Is still O(n) as the letter of the english alphabet are 26 -> O(26 * n))
  and if the character is the one you are considering in the HashMap at the moment:
    - Define pointers i and j
    - Pointer i starts at the occurrence of letter you are considering
    - Move pointer j to the right
    - If s[j] = x move j
    - If s[j] != x decrement k
    - Iterate until k > 0
    - Save the distance j - i + 1 -> that's the substring you can obtain for that letter
      in that position

Space complexity: O(1) as the HashMap has a constant size
Time complexity: O(26 * n * m) where m is the occurrence of the most occurring character
in the string. Worst case scenario in which the string is made by only 1 character, the 
complexity becomes O(n ^ 2)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> letters = new HashMap<>(Map.ofEntries(
            Map.entry('A', 0), Map.entry('B', 0), Map.entry('C', 0), Map.entry('D', 0),
            Map.entry('E', 0), Map.entry('F', 0), Map.entry('G', 0), Map.entry('H', 0),
            Map.entry('I', 0), Map.entry('J', 0), Map.entry('K', 0), Map.entry('L', 0),
            Map.entry('M', 0), Map.entry('N', 0), Map.entry('O', 0), Map.entry('P', 0),
            Map.entry('Q', 0), Map.entry('R', 0), Map.entry('S', 0), Map.entry('T', 0),
            Map.entry('U', 0), Map.entry('V', 0), Map.entry('W', 0), Map.entry('X', 0),
            Map.entry('Y', 0), Map.entry('Z', 0)
        ));
        for(Character c: letters.keySet()) {
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    int l = i;
                    int counter = k;
                    int j = l + 1;
                    while (j < s.length() && (counter > 0 || s.charAt(j) == c)) {
                        if (s.charAt(j) != c) {
                            counter--;
                        }
                        j++;
                    }
                    l -= counter;
                    while (l < 0) {
                        l++;
                    }
                    max = Math.max(max, j - l);
                }
            }
            letters.put(c, Math.max(max, letters.get(c)));
        }

        int result = 0;
        for (Integer i: letters.values()) {
            if (i > result) {
                result = i;
            }
        }
        return result;
    }
}
