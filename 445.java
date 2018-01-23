/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1=0;int n2=0;
        ListNode temp = l1;
        while(temp!=null){temp = temp.next;n1++;}
        temp = l2;
        while(temp!=null){temp = temp.next;n2++;}
        ListNode root = new ListNode(0);
        int a = addTwoNumbers(l1,n1,l2,n2,root);
        if(a==1){root.val=1;return root;}
        else return root.next;
    }
    private int addTwoNumbers(ListNode l1,int n1,ListNode l2,int n2,ListNode root){
        //System.out.printf("%d,%d\n",n1,n2);
        int temp;
        if(n1==0) return 0;
        if(n1==n2){
            ListNode node = new ListNode(0);
            temp = l1.val+l2.val+addTwoNumbers(l1.next,n1-1,l2.next,n2-1,node);
            //System.out.printf("temp0:%d\n",temp);
            node.val = temp%10;
            root.next = node;
            return temp/10;
        }else if(n1<n2){
            ListNode node = new ListNode(0);
            temp = l2.val+addTwoNumbers(l1,n1,l2.next,n2-1,node);
            //System.out.printf("temp1:%d\n",temp);
            node.val = temp%10;
            root.next = node;
            return temp/10;
        }else if(n1>n2){
            ListNode node = new ListNode(0);
            temp = l1.val+addTwoNumbers(l1.next,n1-1,l2,n2,node);
            //System.out.printf("temp2:%d\n",temp);
            node.val = temp%10;
            root.next = node;
            return temp/10;
        }
        return 0;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len_1 = 0;
        int len_2 = 0;
        ListNode head = l1;
        while(head != null){
            head = head.next;
            len_1++;
        }
        head = l2;
        while(head != null){
            head = head.next;
            len_2 ++;
        }
        //System.out.println(len_1 + " " + len_2);
        head = new ListNode(-1);
        ListNode tail = head;
        int i = Math.max(len_1,len_2);
        while(i > 0){
            int num1 = 0,num2 = 0;
            if(i <= len_1){
                num1 = l1.val;
                l1 = l1.next;
            }
            if(i <= len_2){
                num2 = l2.val;
                l2 = l2.next;
            }
            ListNode tmp = new ListNode(num1 + num2);
            tmp.next = head.next;
            head.next = tmp;
            i--;
        }
        ListNode pre = new ListNode(-1);
        tail = tail.next;
        int tmp = 0;
        while(tail != null){
            //System.out.println(tail.val);
            int next = (tail.val + tmp) / 10;
            tail.val = (tail.val + tmp) % 10;
            ListNode trans = tail;
            tail = tail.next;
            trans.next = pre.next;
            pre.next = trans;
            tmp = next;
        }
        if(tmp > 0){
            ListNode one = new ListNode(1);
            one.next = pre.next;
            pre.next = one;
        }
        return pre.next;
    }
}