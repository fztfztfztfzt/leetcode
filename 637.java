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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Double> result = new ArrayList<>();
        queue.offer(root);
        int size;
        long sum;
        TreeNode temp;
        while(!queue.isEmpty()){
            sum=0;
            size = queue.size();
            for(int i=0;i<size;i++){
                temp = queue.poll();
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
                sum+=temp.val;
            }
            result.add(sum/((double)size));
        }
        return result;
    }
}