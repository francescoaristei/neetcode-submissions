/*
* Brute force solution: for each number in the array iterate over all the others
* if you find another number equal to the one in the outer loop it means there is a
* duplicate.
* Time complexity: 0(n^2)
* Space complexity: O(n) -> just the input array
*
* Solution with HashSet: create an HashSet adding the elements of the input array in
* it, evertime check before if the number is already in the Set, if is true, than
* you have a duplicate and return true, if it never happens, return false.
* Time complexity: O(n)
* Space complexity: O(2n) -> space for the Set can be at most the same size of the
* input array.
*
*
*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}