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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result= new LinkedList<List<Integer>>();
        if(root==null) return result;
        if(root.left==null&&root.right==null&&sum==root.val){
            List<Integer> temp = new LinkedList<Integer>();
            temp.add(root.val);
            result.add(temp);
            return result;
        }
        result = pathSum(root.left, sum-root.val);
        for(List<Integer> t : result) ((LinkedList)t).addFirst(root.val);
        List<List<Integer>> right= pathSum(root.right, sum-root.val);
        for(List<Integer> t : right){
            ((LinkedList)t).addFirst(root.val);
            result.add(t);
        }
        return result;
    }
}