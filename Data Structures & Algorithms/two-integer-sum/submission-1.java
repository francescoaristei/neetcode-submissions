/*
* Assumptions:
*   - every input has EXACTLY one pair that satisfy the condition
* Constraints: 
*   - smaller index should be returned first
*
* Brute force solution: For each number in the input array, iterate through all
* the others, if a the sum of the two values matches the target, return the indexes.
* Time complexity: O(n^2)
* Space complexity: O(1)
* 
* Smart solution: Generate a HashMap with the following elements:
*   - key: values of input array
*   - value: index of that value in the array
* 
* Given the pair of values (x, y) in the input array whose sum is = target
* Notice that: target - x = y and target - y = x
* Therefore, knowing this, once the HashMap has been populated, for each key
* compute target - key and if there is another key in the HashMap with that value
* that is the solution -> return the two values (array indexes) associated with those
* two keys in the HashMap.
* Time complexity: O(n)
* Space complexity: O(n)
*
* Case you did not consider: [5, 5] -> your current method returns [1, 1], this solution
* does not cover the case of having two equals number giving the target.
* Solution: the HashMap can be created by iterating through the array, computing
* target - array[i] and if it is already in the HashMap the solution has been found
* otherwise insert it.
* Basically, the HashMap is only a temporary data structure used to store the "other"
* element giving the target, not to store all the elements of the input array.
*
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (diffMap.containsKey(target - nums[i])) {
                return new int[] {diffMap.get(target - nums[i]), i};
            }
            diffMap.put(nums[i], i);
        }
        return null;
    }
}
