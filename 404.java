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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        else return sumOfLeftLeaves(root.left,true)+sumOfLeftLeaves(root.right,false);
    }
    public int sumOfLeftLeaves(TreeNode root, boolean type){
        if(root==null) return 0;
        if(type){
            if(root.left==null&&root.right==null) return root.val;
            else return sumOfLeftLeaves(root.left,true)+sumOfLeftLeaves(root.right,false);
        }else{
            return sumOfLeftLeaves(root.left,true)+sumOfLeftLeaves(root.right,false);
        }
    }
}