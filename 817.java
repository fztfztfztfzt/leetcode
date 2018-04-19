/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int g : G) set.add(g);
        boolean state = false;
        int count = 0;
        while(head!=null){
            boolean flag = set.contains(head.val);
            head=head.next;
            if(flag&&!state){
                count++;
                state=true;
            }else if(!flag&&state){
                state=false;
            }
        }
        return count;
    }
}