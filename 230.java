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
    int num;
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        return helper(root);
    }
    private int helper(TreeNode root){
        if(root==null) return -1;
        int x = helper(root.left);
        if (num==0) return x;
        if (--num==0) return root.val; 
        return helper(root.right);
    }
}