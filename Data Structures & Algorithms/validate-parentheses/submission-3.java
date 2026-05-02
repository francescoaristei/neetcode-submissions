/*
* [({})]
* [][][]
* {{{{[][][(())]}}}}
*
* SOLUTION:
* One stack treated in the following way:
*   - If parentheses is open, of any kind: (, [, { push()
*   - If parentheses is closed, pop() -> if parentheses in top 
*     is not of the same kind, but open, error
*   - When you have iterated over all the chars of the input string s
*     expect the stack to be empty else error
*
* Space complexity: O(n)
* Time complexity: O(n)
*/

class Solution {
    public boolean isValid(String s) {
        // initialize stack
        List<Character> stack = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.add(s.charAt(i));
            } else {
                if (s.charAt(i) == ')' && stack.size() > 0 && stack.get(stack.size() - 1) == '(') {
                    stack.remove(stack.size() - 1);
                } else if (s.charAt(i) == ']' && stack.size() > 0 && stack.get(stack.size() - 1) == '[') {
                    stack.remove(stack.size() - 1);
                } else if (s.charAt(i) == '}' && stack.size() > 0 && stack.get(stack.size() - 1) == '{') {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
