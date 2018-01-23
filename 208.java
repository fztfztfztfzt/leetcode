class Trie {
    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] child = new TrieNode[26];
        public TrieNode(){}
        public TrieNode(char c){
            val = c;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.child[c-'a']==null){
                cur.child[c-'a'] = new TrieNode(c);
            }
            cur = cur.child[c-'a'];
        }
        cur.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.child[c-'a']==null) return false;
            cur = cur.child[c-'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.child[c-'a']==null) return false;
            cur = cur.child[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */