class Solution {
    private boolean check(int[] weights, int days, int load) {
        int count = 1;
        int temp = load;

        for (Integer w: weights) {
            if (temp - w < 0) {
                count++;
                if (count > days) {
                    return false;
                }
                temp = load;
            }
            temp -= w;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sumCapacity = 0;
        for (int i = 0; i < weights.length; i++) {
            sumCapacity += weights[i];
        }

        int maxWeight = Integer.MIN_VALUE;
        for (Integer weight: weights) {
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        int l = maxWeight;
        int r = sumCapacity;
        int result = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(weights, days, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}