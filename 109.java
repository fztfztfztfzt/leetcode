/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        node = head;
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        return sortedListToBST(0,size-1);
    }
    private TreeNode sortedListToBST(int start,int end){
        if(end<start) return null;
        int mid = (start+end)>>>1;
        TreeNode left = sortedListToBST(start,mid-1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        root.left = left;
        TreeNode right = sortedListToBST(mid+1,end);
        root.right = right;
        return root;
    }
}