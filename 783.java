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
    public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;
        if(root==null) return res;
        if(root.left!=null) res=Math.min(res,root.val-maxBST(root.left));
        if(root.right!=null) res=Math.min(res,minBST(root.right)-root.val);
        res = Math.min(res,minDiffInBST(root.left));
        res = Math.min(res,minDiffInBST(root.right));
        return res;
    }
    private int maxBST(TreeNode root){
        while(root.right!=null) root=root.right;
        return root.val;
    }
    private int minBST(TreeNode root){
        while(root.left!=null) root=root.left;
        return root.val;
    }
}

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
    Integer pre = null;
    int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root==null) return Integer.MAX_VALUE;
        minDiffInBST(root.left);
        if(pre!=null) res=Math.min(res,root.val-pre);
        pre=root.val;
        minDiffInBST(root.right);
        return res;
    }
}