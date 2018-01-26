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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,postorder,0,inorder.length-1,postorder.length-1); 
    }
    private TreeNode buildTree(int[] inorder,int[] postorder,int istart,int iend,int ppos){
        if(ppos>=postorder.length||istart>iend) return null;
        TreeNode root = new TreeNode(postorder[ppos]);
        int icur = 0;
        for(int i=istart;i<=iend;i++){
            if(inorder[i]==postorder[ppos]){
                icur = i;
                break;
            }
        }
        root.left = buildTree(inorder,postorder,istart,icur-1,ppos-1-(iend-icur));
        root.right  = buildTree(inorder,postorder,icur+1,iend,ppos-1);
        return root;
    }
}