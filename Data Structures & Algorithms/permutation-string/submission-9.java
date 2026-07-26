class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] s1c = new int[26];
        int[] s2c = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1c[s1.charAt(i) - 'a'] += 1;
            s2c[s2.charAt(i) - 'a'] += 1;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1c[i] == s2c[i]) {
                matches++;
            }
        }

        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            s2c[index]++;
            if (s2c[index] == s1c[index]) {
                matches++;
            } else if (s1c[index] + 1 == s2c[index]) {
                matches--;
            }

            int l = r - s1.length();
            index = s2.charAt(l) - 'a';
            s2c[index]--;
            if (s2c[index] == s1c[index]) {
                matches++;
            } else if (s1c[index] - 1 == s2c[index]) {
                matches--;
            }
        }
        return matches == 26;
    }
}
