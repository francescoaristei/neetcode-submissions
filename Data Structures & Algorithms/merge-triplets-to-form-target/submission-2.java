class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[][] valid = new int[triplets.length][triplets[0].length];

        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] 
                && triplets[i][2] <= target[2]) {
                valid[i] = triplets[i];
            }
        }

        boolean first = false;
        boolean second = false;
        boolean third = false;

        for (int i = 0; i < valid.length; i++) {
            if (valid[i][0] == target[0]) {
                first = true;
            }
            if (valid[i][1] == target[1]) {
                second = true;
            }
            if (valid[i][2] == target[2]) {
                third = true;
            }
        }
        return first && second && third;
    }
}
