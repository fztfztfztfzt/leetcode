/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1) return null;
        int d = 1;
        while(d<lists.length){
            for(int i=0;i+d<lists.length;i+=(2*d)){
                lists[i] = merge2Lists(lists[i],lists[i+d]);
            }
            d*=2;
        }
        return lists[0];
    }
    private ListNode merge2Lists(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if(l1!=null){
            cur.next = l1;
        }
        if(l2!=null){
            cur.next = l2;
        }
        return head.next;
    }
}