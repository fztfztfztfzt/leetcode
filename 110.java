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
    boolean result;
    public boolean isBalanced(TreeNode root) {
        result = true;
        depth(root);
        return result;
    }
    public int depth(TreeNode root){
        if(result == false) return -1;
        if(root==null) return 0;
        int left = depth(root.left);
        if(result == false) return -1;
        int right = depth(root.right);
        if(result == false) return -1;
        if(Math.abs(left-right)>1){result=false;return -1;}
        return Math.max(left,right)+1;
    }
}