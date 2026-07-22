class TimeMap {
    private record Pair(String value, Integer timestamp) implements Comparable<Pair> {
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.timestamp, other.timestamp);
        }
    };
    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
        Collections.sort(map.get(key));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        String result = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
