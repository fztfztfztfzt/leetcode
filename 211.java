class WordDictionary {
    class TreeNode{
        boolean isWord;
        char val;
        Map<Character,TreeNode> map;
        TreeNode(){
            map = new HashMap<>();
            isWord = false;
        }
        TreeNode(char c){
            map = new HashMap<>();
            isWord = false;
            val = c;
        }
    }
    TreeNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TreeNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode temp = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(temp.map.containsKey(c)){
                temp = temp.map.get(c);
            }else{
                temp.map.put(c,new TreeNode(c));
                temp = temp.map.get(c);
            }
        }
        temp.isWord=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word,0,root);
    }
    
    private boolean search(String word,int i,TreeNode cur){
        if(i>=word.length()) return false;
        char c = word.charAt(i);
        if(i==word.length()-1){
            if(c!='.'){
                if(cur.map.containsKey(c)&&cur.map.get(c).isWord) return true;
                return false;
            }else{
                for(Map.Entry<Character,TreeNode> entry : cur.map.entrySet()){
                    if(entry.getValue().isWord) return true;
                }
                return false;
            }
        }
        if(c!='.'){
            if(cur.map.containsKey(c)){
                return search(word,i+1,cur.map.get(c));
            }else{
                return false;
            }
        }else{
            for(Map.Entry<Character,TreeNode> entry : cur.map.entrySet()){
                if(search(word,i+1,entry.getValue())) return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */