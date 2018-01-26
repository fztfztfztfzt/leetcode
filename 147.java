/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return head;
        ListNode helper = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = helper;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            while(pre.next!=null&&pre.next.val<cur.val) pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }
}