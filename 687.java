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
    private int result;
    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        if(root!=null) dfs(root);
        return result;
    }
    private int dfs(TreeNode root){
        int l = root.left==null?0:dfs(root.left);
        int r = root.right==null?0:dfs(root.right);
        int ll = root.left!=null&&root.left.val==root.val?l+1:0;
        int rr = root.right!=null&&root.right.val==root.val?r+1:0;
        result = Math.max(result,ll+rr);    
        return Math.max(ll,rr);
    }
}