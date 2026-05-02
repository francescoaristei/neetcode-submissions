/*
* Complexity: for each string in the array strs, need to iterate over each
* char and check the fixed size array of 26 chars to check which char it 
* corresponds to.
* Therefore: O(n * (m * 26)) = O (n*m)
* With n = length of strs and m max length of the strings within strs.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Character> alphabet = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'k', 'h', 'i', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'z',
            'w', 'x', 'y', 'j'
        );
        // create a HashMap with key the occurrence of each char of 'alphabet'
        // into the strings of strs
        // in this way two strings in strs which are anagrams end up in the same
        // bucket of the hash map
        Map<List<Integer>, List<String>> mapOfAnagrams = new HashMap<>();
        for (String str: strs) {
            List<Integer> indexList = new ArrayList<>(Collections.nCopies(26, 0));
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < alphabet.size(); j++) {
                    if (str.charAt(i) == alphabet.get(j)) {
                        indexList.set(j, indexList.get(j) + 1);
                    }
                }
            }
            if (mapOfAnagrams.containsKey(indexList)) {
                List<String> anagrams = mapOfAnagrams.get(indexList);
                anagrams.add(str);
                mapOfAnagrams.put(indexList, anagrams);
                continue;
            }
            // NOTE: defining as
            // mapOfAnagrams.put(indexList, Arrays.asList(str)); is wrong ->
            // it creates a fixed-size List that cannot be modified with add()
            mapOfAnagrams.put(indexList, new ArrayList<>(Arrays.asList(str)));
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> value: mapOfAnagrams.values()) {
            result.add(value);
        }
        return result;
    }
}
