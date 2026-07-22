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
        int mid = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            }
            if (list.get(mid).timestamp > timestamp) {
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        if (mid > 0 && list.get(mid).timestamp > timestamp) {
            return list.get(mid - 1).value;
        }
        if (list.get(mid).timestamp < timestamp) {
            return list.get(mid).value;
        }
        return "";
    }
}
