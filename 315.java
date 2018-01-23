class Solution {
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
    private Node insert(Node root,int data,int i,int pre){
        if(root==null){
            //System.out.println("1");
            result[i]=pre;
            root = new Node(data,0);
        }else if(root.val==data){
            //System.out.println("2");
            root.dup++;
            result[i]=pre+root.sum;
        }else if(root.val>data){
            //System.out.println("3");
            root.sum++;
            root.left = insert(root.left,data,i,pre);
        }else{
            //System.out.println("4");
            root.right = insert(root.right,data,i,pre+root.sum+root.dup);
        }
        return root;
    }
    Integer[] result;
    public List<Integer> countSmaller(int[] nums) {
        result = new Integer[nums.length];
        Node root = null;
        for(int i=nums.length-1;i>=0;i--){
            //System.out.printf("d:%d\n",nums[i]);
            root = insert(root,nums[i],i,0);
        }
        return Arrays.asList(result);
    }
}