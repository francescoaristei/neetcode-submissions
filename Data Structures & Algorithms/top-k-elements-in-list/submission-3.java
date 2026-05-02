/*
* - Create a HashMap with
*   - key: element of nums
*   - value: number of occurrences in nums
* - Create an output array of size k
* - Take a random key of the map and save it in the output array
* - Compare its values with all the other values of the map
* - The biggest goes into output[0]
* - Repeat the process with another element of the map (excluding the one you saved)
* - Repeat k times
* - At the end output contains the k most frequent elements of the input array
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create Map with key elements of nums and values #occurrences within nums
        Map<Integer, Integer> numsToFreq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsToFreq.containsKey(nums[i])) {
                numsToFreq.put(nums[i], numsToFreq.get(nums[i]) + 1);
                continue;
            }
            numsToFreq.put(nums[i], 1);
        }
        int[] output = new int[k];
        // initialize the set of already added elements
        Set<Integer> alreadyAdd = new HashSet<>();
        int counter = 0;
        while (counter < k) {
            Integer tempVal = -1;
            Integer tempKey = 1001;
            for (Map.Entry<Integer,Integer> entry2: numsToFreq.entrySet()) {
                if (!alreadyAdd.contains(entry2.getKey()) && 
                entry2.getValue() > tempVal) {
                    tempVal = entry2.getValue();
                    tempKey = entry2.getKey();
                }
            }
            output[counter] = tempKey;
            alreadyAdd.add(tempKey);
            counter ++;
        }
        return output;
    }
}
