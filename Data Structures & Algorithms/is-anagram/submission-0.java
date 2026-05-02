/*
* Brute force solution: Sort the two strings and then compare the contents
* of the two strings, if they are the same it means that the original strings
* were anagrams of each other, otherwise they were not.
* Time complexity: Cost of sorting: O(n * log(n) + m * log(m))
* Space complexity: O(1)
*
* Solution with HashMap of english letters: HashMap with keys english
* letters, and initial value of 0. 
* Scan each char of the first string and increment value of the hashmap cell
* associated with that char.
* Scan each char of the second string and decrement the value of the hashmap
* cell associated with that char.
* Scan the hashmap, if they are anagram you expect to have each cell with value 0.
* Time complexity: O(n + m + 21) = O(n + m) where 21 is the constant size of the 
* hashmap.
* Space complexity: O(21) = O(1)
*
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> letters = new HashMap<>();
        letters.put('a', 0);
        letters.put('b', 0);
        letters.put('c', 0);
        letters.put('d', 0);
        letters.put('e', 0);
        letters.put('f', 0);
        letters.put('g', 0);
        letters.put('h', 0);
        letters.put('i', 0);
        letters.put('l', 0);
        letters.put('m', 0);
        letters.put('n', 0);
        letters.put('o', 0);
        letters.put('p', 0);
        letters.put('q', 0);
        letters.put('r', 0);
        letters.put('s', 0);
        letters.put('t', 0);
        letters.put('u', 0);
        letters.put('v', 0);
        letters.put('z', 0);
        letters.put('w', 0);
        letters.put('x', 0);
        letters.put('y', 0);
        letters.put('z', 0);
        letters.put('j', 0);
        for (int i = 0; i < s.length(); i++) {
            if (letters.containsKey(s.charAt(i))) {
                int value = letters.get(s.charAt(i));
                letters.put(s.charAt(i), value + 1);
            }
        }
        for (int j = 0; j < t.length(); j++) {
            if (letters.containsKey(t.charAt(j))) {
                int value = letters.get(t.charAt(j));
                letters.put(t.charAt(j), value - 1);
            }
        }
        for (Integer value: letters.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
