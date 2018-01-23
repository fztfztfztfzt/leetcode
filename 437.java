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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return helper(root,sum,map,0);
    }
    public int helper(TreeNode root, int sum,Map<Integer,Integer> map,int sumSoFar){
        if(root==null) return 0;
        sumSoFar += root.val;
        int num = map.getOrDefault(sumSoFar-sum,0);
        map.put(sumSoFar,map.getOrDefault(sumSoFar,0)+1);
        num+=(helper(root.left,sum,map,sumSoFar)+helper(root.right,sum,map,sumSoFar));
        map.put(sumSoFar,map.get(sumSoFar)-1);
        return num;
    }
}