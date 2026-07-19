class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length - 1;
        Stack<Integer> values = new Stack<>();
        Stack<Integer> idxs = new Stack<>();

        int[] result = new int[len + 1];

        values.push(temperatures[len]);
        idxs.push(len);

        for (int i = len - 1; i >= 0; i--) {
            while (!values.isEmpty()) {
                if (temperatures[i] < values.peek()) {
                    result[i] = idxs.peek() - i;
                    break;
                }
                values.pop();
                idxs.pop();
            }
            values.push(temperatures[i]);
            idxs.push(i);
        }
        return result;
    }
}
