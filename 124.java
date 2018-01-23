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
    int result;
    public int maxPathSum(TreeNode root) {
        result=Integer.MIN_VALUE;
        maxOnePathSum(root);
        return result;
    }
    public int maxOnePathSum(TreeNode root){
        if(root==null) return 0;
        int l = Math.max(0,maxOnePathSum(root.left));
        int r = Math.max(0,maxOnePathSum(root.right));
        result=Math.max(result,l+r+root.val);
        return Math.max(l,r)+root.val;
    }
}