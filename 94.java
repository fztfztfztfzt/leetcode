/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(root!=null||!st.empty()){
            if(root==null){
                root = st.pop();
                result.add(root.val);
                root = root.right;
            }else{
                st.push(root);
                root = root.left;
            }
        }
        return result;
    }
}