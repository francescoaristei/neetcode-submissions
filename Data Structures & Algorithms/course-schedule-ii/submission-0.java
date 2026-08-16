class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()) {
            int node = q.poll();
            list.add(node);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == node) {
                    if(--indegrees[prerequisites[i][0]] == 0) {
                        q.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result.length == numCourses ? result : new int[0];
    }
}
