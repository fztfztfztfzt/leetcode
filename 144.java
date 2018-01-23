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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        while(root!=null||!st.empty()){
            if(root==null){
                root = st.pop();
            }else{
                result.add(root.val);
                st.push(root.right);
                root = root.left;
            }
        }
        return result;
    }
}