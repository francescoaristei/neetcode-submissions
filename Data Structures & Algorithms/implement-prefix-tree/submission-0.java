class TrieNode {
    protected boolean isEndWord;
    protected TrieNode[] children;

    public TrieNode() {
        isEndWord = false;
        children = new TrieNode[26];
    }
}

class PrefixTree {
    private TrieNode root = new TrieNode();

    public PrefixTree() {}

    public void insert(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndWord = true;
    }

    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isEndWord;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private TrieNode traverse(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (node.children[idx] == null) {
                return null;
            }

            node = node.children[idx];
        }
        return node;
    }
}
