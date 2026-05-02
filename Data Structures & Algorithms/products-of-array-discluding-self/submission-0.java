/*
* Solution 1: 
*   - Make the product of all the elements of the input array
*   - Create the output array, which has same size of input array
*   - Iterate along the input array and set output[i] = tot_product / input[i]
*
* Complexity: O(n)
*
* Solution 2:
*   - Compute a prefix product array of the input array
*   - Compute a postfix product array of the input array
*   - Element at position i of output array output[i] = prefix[i] + postfix[i]
*
* Complexity: O(2*n) = O(n)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int[] postfix = new int[nums.length];
        postfix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            postfix[j] = postfix[j+1] * nums[j+1];
        }
        int[] output = new int[nums.length];
        for (int t = 0; t < nums.length; t++) {
            output[t] = prefix[t] * postfix[t];
        }
        return output;
    }
}  
