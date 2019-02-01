/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode* fast = head;
        ListNode* slow = head;
        while(fast!=NULL){
            fast = fast->next;
            if(fast==NULL) return slow;
            fast = fast->next;
            slow = slow->next;
        }
        return slow;
    }
};
