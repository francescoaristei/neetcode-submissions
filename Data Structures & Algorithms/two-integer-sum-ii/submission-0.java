class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int idx1 = 0;
        int idx2 = numbers.length - 1;
        int[] result = new int[2];

        while (idx1 < idx2) {
            int diff = target - numbers[idx2];
            if (diff < numbers[idx1]) {
                idx2 -= 1;
            } else if (diff > numbers[idx1]) {
                idx1 += 1;
            } else {
                result[0] = idx1 + 1;
                result[1] = idx2 + 1;
                break;
            }
        }
        return result;
    }
}
