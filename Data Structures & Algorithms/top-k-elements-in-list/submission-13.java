/*
* The algorithm is inspired to Bucket Sort. 
* - Whatever is the number of occurrences of each number, it cannot be > n
* - Create an array of List of size n
* - Iterate over the input array and for each element compute the number of occurrences
* - Insert in position i = number of occurrences of element x, the element x
* - Iterate starting from the bottom k times and add each element encountered in the List to a output array
* 
* Complexity is O(n) because you need to iterate over the input array
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Initialize array of List where each element of the array is
        // the frequency of a number and each List in that element is the 
        // list of numbers with that frequency 
        List<Integer>[] bucketList = new ArrayList[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            bucketList[i] = new ArrayList<>();
        }

        // Define the map having as key the numbers of the input 
        // and value the frequency of that number in the input array
        Map<Integer, Integer> mapOfFreq = new HashMap<>();
        for (Integer num: nums) {
            mapOfFreq.put(num, mapOfFreq.getOrDefault(num, 0) + 1);
        }

        // Insert into the element i the List of numbers with frequency i
        for (Map.Entry<Integer, Integer> entry: mapOfFreq.entrySet()) {
            bucketList[entry.getValue()].add(entry.getKey());
        }

        // iterate backwards in the array of list k times and save the numbers
        // in a result array
        int[] result = new int[k];
        int i = 0;
        for (int idx = bucketList.length - 1; idx >= 0; idx--) {
            for (Integer el: bucketList[idx]) {
                result[i++] = el;
                if (i == k) {
                    return result;
                }
            }
        }
        return result;
    }
}