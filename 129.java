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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    private int sumNumbers(TreeNode root,int pre){
        if(root==null) return pre;
        int temp = pre*10+root.val;
        if(root.left==null&&root.right==null) return temp;
        if(root.left==null&&root.right!=null) return sumNumbers(root.right,temp);
        if(root.left!=null&&root.right==null) return sumNumbers(root.left,temp);
        return sumNumbers(root.left,temp)+sumNumbers(root.right,temp);
    }
}