class MapSum {
    class TreeNode {
        Map<Character, TreeNode> children;
        int value;
        
        public TreeNode(){
            children = new HashMap<Character,TreeNode>();
            value = 0;
        }
    }
    
    TreeNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TreeNode();
    }
    
    public void insert(String key, int val) {
        TreeNode curr = root;
        TreeNode temp;
        for(char c : key.toCharArray()){
            temp = curr.children.get(c);
            if (temp == null) {
                curr.children.put(c, new TreeNode());
                temp = curr.children.get(c);
            }
            curr = temp;
        }
        curr.value = val;
    }
    
    public int sum(String prefix) {
        TreeNode temp = root;
        for(char c : prefix.toCharArray()){
            temp = temp.children.get(c);
            if(temp==null) return 0;
        }
        return dfs(temp);
    }
    private int dfs(TreeNode temp){
        int sum = 0;
        for(char c : temp.children.keySet()){
            sum += dfs(temp.children.get(c));
        }
        return sum+temp.value;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */