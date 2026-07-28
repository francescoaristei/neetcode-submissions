class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0; // double the speed of slow

        // iterate until they meet
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (fast == slow) {
                break;
            }
        }

        // create a second slow pointer
        // iterate until they meet
        int sslow = 0;
        while (slow != sslow) {
            slow = nums[slow];
            sslow = nums[sslow];
        }

        // this is the "start" of the cycle
        // hence in this exercise the repeating value
        return slow;
    }
}
