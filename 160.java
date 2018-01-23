/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if((headA==null)||(headB==null)) return null;
        ListNode nodeA = headA;
        int a=0;
        while(nodeA!=null){
            a = a+1;
            nodeA = nodeA.next;
        }
        nodeA = headA;
        ListNode nodeB = headB;
        int b=0;
        while(nodeB!=null){
            b = b+1;
            nodeB = nodeB.next;
        }
        nodeB = headB;
        while(a>b){
            a = a-1;
            nodeA = nodeA.next;
        }
        while(b>a){
            b = b-1;
            nodeB = nodeB.next;
        }
        while(nodeA!=nodeB){
            nodeA=nodeA.next;
            nodeB=nodeB.next;
        }
        return nodeA;
    }
}

