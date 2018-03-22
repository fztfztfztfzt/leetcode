/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p1 = root;
        ListNode p2 = head;
        while(p2!=null){
            while(p2.next!=null&&p2.next.val==p2.val){
                p2 = p2.next;
            }
            if(p1.next==p2) p1 = p2;
            else p1.next = p2.next;
            p2 = p2.next;
        }
        return root.next;
    }
}