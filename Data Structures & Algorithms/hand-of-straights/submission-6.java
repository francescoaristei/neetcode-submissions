class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            count.put(hand[i], count.getOrDefault(hand[i], 0) + 1);
        }

        Arrays.sort(hand);

        // 1, 2, 2, 3, 3, 4, 4, 5
        for (int num: hand) {
            if (count.get(num) > 0) {
                for (int i = num; i < num + groupSize; i++) {
                    if (count.getOrDefault(i, 0) == 0) {
                        return false;
                    }
                    count.put(i, count.get(i) - 1);
                }
            }
        }
        return true;
    }
}
