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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root==null) return result;
        if(root.left==null&&root.right==null){
            result.add(Integer.toString(root.val));
            return result;
        }
        for(String t : binaryTreePaths(root.left)){
            result.add(root.val+"->"+t);
        }
        for(String t : binaryTreePaths(root.right)){
            result.add(root.val+"->"+t);
        }
        return result;
    }
}