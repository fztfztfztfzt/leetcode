/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode s = small;
        ListNode l = large;
        while(head!=null){
            if(head.val<x){
                s.next=head;
                s = head;
            }else{
                l.next=head;
                l = head;
            }
            head = head.next;
        }
        l.next = null;
        s.next = large.next;
        return small.next;
    }
}