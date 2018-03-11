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
    class TreeNodePlus {
        int time;
        TreeNode root;
        TreeNodePlus(TreeNode r,int t){
            time = t;
            root = r;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNodePlus> stack = new Stack<>();
        stack.push(new TreeNodePlus(root,1));
        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            TreeNodePlus temp = stack.pop();
            if(temp.root==null) continue;
            if(temp.time==1){
                stack.push(new TreeNodePlus(temp.root,0));
                stack.push(new TreeNodePlus(temp.root.right,1));
                stack.push(new TreeNodePlus(temp.root.left,1));
            }else{
                res.add(temp.root.val);
            }
        }
        return res;
    }
}

