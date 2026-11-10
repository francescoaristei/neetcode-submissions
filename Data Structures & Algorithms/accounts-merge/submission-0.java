class Solution {
    private Map<String, Integer> emailIdx = new HashMap<>();
    private List<String> emails = new ArrayList<>();
    private Map<Integer, Integer> emailAccId = new HashMap<>(); // string to first account
    private List<List<Integer>> adj = new ArrayList<>();
    private boolean[] visited;
    private Map<Integer, List<String>> emailGroup = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size(); // number of accounts
        int m = 0; // indexes of the emails

        // assign a unique index m to each unique email
        // add each unique email in the emails list
        // assign to each unique email the number of the first account where it appears
        for (int accId = 0; accId < n; accId++) {
            List<String> account = accounts.get(accId);
            for (int i = 1; i < account.size(); i++) {
                if (!emailIdx.containsKey(account.get(i))) {
                    emailIdx.put(account.get(i), m);
                    emails.add(account.get(i));
                    emailAccId.put(m, accId);
                    m++;
                }
            }
        }

        // initialize adjacency list
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
        }


        // create the adjacency list
        for (int accId = 0; accId < n; accId++) {
            List<String> account = accounts.get(accId);
            for (int i = 2; i < account.size(); i++) {
                int idx1 = emailIdx.get(account.get(i));
                int idx2 = emailIdx.get(account.get(i - 1));
                adj.get(idx1).add(idx2);
                adj.get(idx2).add(idx1);
            }
        }

        // populate email group
        visited = new boolean[m];

        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                int accId = emailAccId.get(i);
                emailGroup.putIfAbsent(accId, new ArrayList<>());
                dfs(accId, i);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (Integer accId: emailGroup.keySet()) {
            List<String> group = emailGroup.get(accId);
            Collections.sort(group);
            List<String> grouped = new ArrayList<>();
            grouped.add(accounts.get(accId).get(0));
            grouped.addAll(group);
            res.add(grouped);
        }
        return res;
    }

    private void dfs(int accId, int node) {
        visited[node] = true;
        emailGroup.get(accId).add(emails.get(node));
        for (Integer n: adj.get(node)) {
            if (!visited[n]) {
                dfs(accId, n);
            }
        }
    }
}