class Solution {
    private boolean checkK(int[] piles, int h, int k) {
        int counter = 0;
        for (int i = 0; i < piles.length; i++) {
            counter += (piles[i] + k - 1) / k;
        }
        return counter <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int result = 0;

        // find max of piles
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (checkK(piles, h, mid)) {
                result = mid;
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        return result;
    }
}
