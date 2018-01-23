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
    int maxCount;
    Map<Integer,Integer> sumToCount;
    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        sumToCount = new HashMap<Integer,Integer>();
        TreeSum(root);
        List<Integer> result = new ArrayList<>();
        for(int key : sumToCount.keySet()){
            if(sumToCount.get(key)==maxCount) result.add(key);
        }
        int[] res = new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);
        }
        return res;
    }
    private int TreeSum(TreeNode root){
        if(root==null) return 0;
        int left = TreeSum(root.left);
        int right = TreeSum(root.right);
        int sum = left+right+root.val;
        int count = sumToCount.getOrDefault(sum,0)+1;
        sumToCount.put(sum,count);
        maxCount = Math.max(maxCount,count);
        return sum;
    }
}