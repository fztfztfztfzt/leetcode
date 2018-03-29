/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode r = head;
        ListNode l = head;
        while(r.next!=null&&r.next.next!=null){
            l = l.next;
            r = r.next.next;
        }
        ListNode head2 = new ListNode(0);
        ListNode p = l.next;
        l.next = null;
        while(p!=null){
            ListNode tmp = p.next;
            p.next = head2.next;
            head2.next = p;
            p = tmp;
        }
        head2 = head2.next;
        ListNode head1 = head;
        while(head2!=null){
            ListNode temp = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = temp;
            head1 = temp;
        }
    }
}