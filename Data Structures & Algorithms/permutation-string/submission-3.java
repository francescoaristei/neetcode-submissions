class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        for (int i = 0; i + s1.length() <= s2.length(); i++) {
            boolean result = true;
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < i + s1.length(); j++) {
                if (map.containsKey(s2.charAt(j))) {
                    map.put(s2.charAt(j), map.get(s2.charAt(j)) + 1);
                    continue;
                }
                map.put(s2.charAt(j), 1);
            }
            for (int z = 0; z < s1.length(); z++) {
                if (!map.containsKey(s1.charAt(z))) {
                    break;
                }
                map.put(s1.charAt(z), map.get(s1.charAt(z)) - 1);
            }
            for (Integer value: map.values()) {
                if (value != 0) {
                    result = false;
                }
            }
            if (result) {
                return true;
            }
        }
        return false;
    }
}
