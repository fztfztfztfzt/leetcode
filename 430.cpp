/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;

    Node() {}

    Node(int _val, Node* _prev, Node* _next, Node* _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
public:
    Node* flatten(Node* head) {
        if(head==NULL) return head;
        tail = NULL;
        return flatten2(head);
    }
private:
    Node* tail;
    Node* flatten2(Node* head){
        Node* cur = head;
        while(cur->next!=NULL){
            //printf("%d\n",cur->val);
            if(cur->child!=NULL){
                Node* post = cur->next;
                Node* child = flatten2(cur->child);
                cur->child = NULL;
                cur->next = child;
                child->prev = cur;
                post->prev = tail;
                tail->next = post;
                cur = post;
            }else{
                cur = cur->next;
            }
        }   
        if(cur->child!=NULL){
            Node* child = flatten2(cur->child);
            cur->next = child;
            cur->child = NULL;
            child->prev = cur;
        }else{
            tail = cur;
        }
        return head;
    }
};
