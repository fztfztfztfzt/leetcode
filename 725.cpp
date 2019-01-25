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
    vector<ListNode*> splitListToParts(ListNode* root, int k) {
        int size = 0;
        ListNode* cur = root;
        while(cur!=NULL){
            cur = cur->next;
            size++;
        }
        int n = size/k;
        int m = size%k;
        vector<ListNode*> res;
        cur = root;
        for(int i=0;i<m;i++){
            ListNode* tmp = cur;
            for(int j=0;j<n;j++) cur = cur->next;
            ListNode* end = cur;
            cur = cur->next;
            end->next = NULL;
            res.push_back(tmp);
        }
        for(int i=0;i<k-m;i++){
            if(cur==NULL) res.push_back(NULL);
            else{
                ListNode* tmp = cur;
                for(int j=0;j<n-1;j++) cur = cur->next;
                ListNode* end = cur;
                cur = cur->next;
                end->next = NULL;
                res.push_back(tmp);
            }
        }
        return res;
    }
};
