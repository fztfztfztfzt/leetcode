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
    public int widthOfBinaryTree(TreeNode root) {
        return widthOfBinaryTree(root,new ArrayList<>(),new ArrayList<>(),0,0);
    }
    private int widthOfBinaryTree(TreeNode root,List<Integer> start,List<Integer> end,int level,int i){
        if(root==null) return 0;
        if(start.size()==level){
            start.add(i);end.add(i);
        }else end.set(level,i);
        int cur = end.get(level)-start.get(level)+1;
        int left = widthOfBinaryTree(root.left,start,end,level+1,2*i+1);
        int right = widthOfBinaryTree(root.right,start,end,level+1,2*i+2);
        return Math.max(cur,Math.max(left,right));
    }
}