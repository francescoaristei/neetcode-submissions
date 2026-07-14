class TrieNode {
    protected boolean isWordEnd;
    protected Map<Character, TrieNode> children;

    public TrieNode() {
        isWordEnd = false;
        children = new HashMap<>();
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (curr.children.get(c) == null) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWordEnd = true;
    }

    public boolean search(String word) {
        return traverse(root, word);
        //TrieNode node = traverse(root, word);
        //return node.isWordEnd;
    }

    private boolean traverse(TrieNode node, String word) {

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                boolean res = false;
                for (TrieNode value: node.children.values()) {
                    if (value != null) {
                        res = res || traverse(value, word.substring(i + 1, word.length()));
                    }
                }
                return res;
            }

            if (node.children.get(c) == null) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isWordEnd;
    }
}
