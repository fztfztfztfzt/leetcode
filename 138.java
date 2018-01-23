/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newHead,l1,l2;
        if(head==null) return head;
        for(l1=head;l1!=null;l1=l1.next.next){
            l2 = new RandomListNode(l1.label);
            l2.next=l1.next;
            l1.next=l2;
        }
        newHead=head.next;
        for(l1=head;l1!=null;l1=l1.next.next){
            if(l1.random!=null) l1.next.random=l1.random.next;
        }
        for(l1=head;l1!=null;l1=l1.next){
            l2=l1.next;
            l1.next=l2.next;
            if(l2.next!=null) l2.next=l2.next.next;
        }
        return newHead;
    }
}