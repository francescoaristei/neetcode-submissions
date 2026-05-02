/*
* SOLUTION:
*   - Two-pointers
*   - one pointer at the beginning
*   - one pointer at the end
*   - iterate inward to the string
*   - check s[pointer_1] == s[pointer_2]
*   - if true continue else return false
*   - if len(s) = even -> iterate until pointer_1 > pointer_2
*   - if len(s) = odd -> iterate until pointer_1 == pointer_2
*
*
* EDGE CASES
*   - if s empty -> false
*   - if len(s) = 1 -> return true
*/

class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        int p1 = 0;
        int p2 = s.length() - 1;
        boolean is_even = s.length() % 2 == 0;
        if (is_even) {
            while (p1 < p2) {
                if (s.charAt(p1) != s.charAt(p2)) {
                    return false;
                }
                p1 += 1;
                p2 -= 1;
            }
        } else {
            while (p1 != p2) {
                if (s.charAt(p1) != s.charAt(p2)) {
                    return false;
                }
                p1 += 1;
                p2 -= 1;
            }
        }
        return true;
    }
}
