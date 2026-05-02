/*
* Intuition: 
*   - Given the pointers of the sliding window: i, j
*   - Start defining maxProfit = prices[j] - prices[i] 
*       - With prices[j] > prices[i]
*       - j > i 
*   - Update the index i only when prices[i] > prices[j]
*       - Given the example [10, 1, 5, 6, 7, 1, 20]
*       - If i = 1, prices[i] = 1 it does not make sense to update
*         i with 2 having prices[i] = 5 because if there is a price
*         in the future that is higher, like 20, it will always be better
*         to have bought the product at price 1 making 20 - 1 = 19 profit
*         then 20 - 5 = 15
*
* Time complexity: O(n)
* Space complexity: O(1)
*/        

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = i + 1;
        int maxProfit = 0;
        while (j < prices.length) {
            if (prices[j] > prices[i]) {
                int temp = prices[j] - prices[i];
                if (temp > maxProfit) {
                    maxProfit = temp;
                }
                j++;
            } else {
                i = j;
                j = i +1;
            }
        }
        return maxProfit;
    }
}
