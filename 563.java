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
    int tilt=0;
    public int findTilt(TreeNode root) {
        solve(root);
        return tilt;
    }
    public int solve(TreeNode root){
        if(root==null) return 0;
        int a = solve(root.left);
        int b = solve(root.right);
        tilt+=Math.abs(a-b);
        return a+b+root.val;
    } 
}