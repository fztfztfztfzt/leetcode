/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        while(head!=null && head.val==val) head=head.next;
        ListNode point = head;
        while(point!=null && point.next!=null){
            while(point.next!=null && point.next.val==val) point.next=point.next.next;
            point=point.next;
        }
        return head;
    }
}