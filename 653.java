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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        Stack<TreeNode> lstack = new Stack<>();
        Stack<TreeNode> rstack = new Stack<>();
        stackAdd(lstack,root,true);
        stackAdd(rstack,root,false);
        while(lstack.peek()!=rstack.peek()){
            int temp = lstack.peek().val+rstack.peek().val;
            if(temp==k) return true;
            else if(temp<k) stackNext(lstack,true);
            else stackNext(rstack,false);
        }
        return false;
    }
    private void stackNext(Stack<TreeNode> stack,boolean isLeft){
        TreeNode temp = stack.pop();
        if(isLeft){
            stackAdd(stack,temp.right,true);
        }else{
            stackAdd(stack,temp.left,false);
        }
    }
    private void stackAdd(Stack<TreeNode> stack,TreeNode root,boolean isLeft){
        while(root!=null){
            stack.push(root);
            root=(isLeft)?root.left:root.right;
        }
    }

}