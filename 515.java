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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        queue.offer(root);
        int n;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            n=queue.size();
            max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode temp = queue.poll();
                if(temp.val>max) max = temp.val;
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
            }
            result.add(max);
        }
        return result;
    }
}