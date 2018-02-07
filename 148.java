/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre=null,slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);
        return merge(head1,head2);
    }
    private ListNode merge(ListNode head1,ListNode head2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                p.next = head1;
                head1 = head1.next;
                p = p.next;
            }else{
                p.next = head2;
                head2 = head2.next;
                p = p.next;
            }
        }
        if(head1==null){
            p.next = head2;
        }
        if(head2==null){
            p.next = head1;
        }
        return head.next;
    }
}