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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums,int start,int end) {
        if(start>end) return null;
        int maxi = start;
        for(int i=start+1;i<=end;i++){
            if(nums[i]>nums[maxi]){
                maxi=i;
            }
        }
        TreeNode root = new TreeNode(nums[maxi]);
        root.left=constructMaximumBinaryTree(nums,start,maxi-1);
        root.right=constructMaximumBinaryTree(nums,maxi+1,end);
        return root;
    }
}