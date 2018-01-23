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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            return temp;
        }else{
            addOneRow(root,v,d,1);
            return root;
        }
    }
    private void addOneRow(TreeNode root,int v,int d,int l){
        if(root==null) return;
        if(l<d-1){
            addOneRow(root.left,v,d,l+1);
            addOneRow(root.right,v,d,l+1);
        }else if(l==d-1){
            TreeNode temp;
            temp = new TreeNode(v);
            temp.left = root.left;
            root.left = temp;
            temp = new TreeNode(v);
            temp.right = root.right;
            root.right = temp;
            return;
        }
    }
}