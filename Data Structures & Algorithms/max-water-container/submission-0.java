/*
* Brute Force: For each number of the heights array, compute the
* area with all the other elements of heights and return the max
* The complexity is O(n * n) as you need two nested loops with 
* O(1) space complexity.
*
*
* [1, 7, 2, 5, 4, 7, 3, 6]
* NOTE: If you compute the area between heigths[0] = 1 and heights[7] = 6
* you obtain area = min(heights[7] - heights[0]) * (7 - 0) = 1 * 7 = 7
* Now, it does not make sense to keep checking the area with heights[0]
* because if heights[7-1] is bigger than heights[7] still the min with
* heights[0] gives heights[0] but now the distance between the two (the base)
* of the area is smaller, therefore, it makes sense to advance on the left
* with heights[1] and keep heights[7] and compute the area.
* So the idea could be to
*   - Have two pointers i, j starting at 0 heights.length - 1
*   - Compute the area and save it in a variable
*   - Advance the pointer of the min(heights[i], heights[j])
*
* In this way you don't compute all possible areas, but you avoid computing
* areas that you are sure are not going to be the max area
*/

class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = 0;
        while (l < r) {
            // compute the area
            int height = Math.min(heights[l], heights[r]);
            int temp = (r - l) * height;
            if (temp > max) {
                max = temp;
            }
            // move from the min height
            if (heights[l] > heights[r]) {
                r--;
            } else if (heights[l] < heights[r]) {
                l++;
            } else {
                // if they are equal move one of the two
                l++;
            }
        }
        return max;
    }
}
