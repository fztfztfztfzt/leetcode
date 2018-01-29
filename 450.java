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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val<key) root.right = deleteNode(root.right,key);
        else if(root.val>key) root.left = deleteNode(root.left,key);
        else{
            if(root.left==null&&root.right==null) return null;
            else if(root.left!=null&&root.right==null) return root.left;
            else if(root.left==null&&root.right!=null) return root.right;
            else{
                TreeNode temp = root.right;
                while(temp.left!=null) temp = temp.left;
                root.val = temp.val;
                root.right = deleteNode(root.right,temp.val);
            }
        }
        return root;
    }
}