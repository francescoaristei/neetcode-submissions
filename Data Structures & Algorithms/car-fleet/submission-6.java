class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            int[] car = {position[i], speed[i]};
            cars[i] = car;
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> s = new Stack<>();

        for (int i = cars.length - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                s.push(cars[i]);
            } else {
                double t1 = (double) (target - s.peek()[0]) / s.peek()[1];
                double t2 = (double) (target - cars[i][0]) / cars[i][1];
                if (t1 >= t2) {
                    continue;
                }
                s.push(cars[i]);
            }
        }

        int counter = 0;
        while(!s.isEmpty()) {
            counter += 1;
            s.pop();
        }
        return counter;
    }
}
