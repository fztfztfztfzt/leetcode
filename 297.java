/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static char spliter = ',';
    private static char none = '*';
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        //System.out.println(sb.toString());
        return sb.toString();
    }
    private void buildString(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(none).append(spliter);
        }else{
            sb.append(root.val).append(spliter);
            buildString(root.left,sb);
            buildString(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        TreeNode root = buildTree(queue);
        return root;
    }
    private TreeNode buildTree(Queue<String> data){
        String d = data.poll();
        if(d.equals("*")) return null;
        //System.out.println(d);
        TreeNode root = new TreeNode(Integer.parseInt(d));
        root.left = buildTree(data);
        root.right = buildTree(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));