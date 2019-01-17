struct Node{
    int val;
    struct Node* next;
    struct Node* prev;
};

class MyLinkedList {
public:
    /** Initialize your data structure here. */
    MyLinkedList() {
        size = 0;
        head = new Node();
        tail = new Node();
        head->next = tail;
        tail->prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        if(index<0||index>=size) return -1;
        return getNode(index)->next->val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val) {
        struct Node* tmp = new Node();
        tmp->val = val;
        tmp->next = head->next;
        tmp->prev = head;
        head->next->prev = tmp;
        head->next = tmp;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        struct Node* tmp = new Node();
        tmp->val = val;
        tmp->next = tail;
        tmp->prev = tail->prev;
        tail->prev->next = tmp;
        tail->prev = tmp;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        if(index<0||index>size) return;
        struct Node* prevNode = getNode(index);
        struct Node* tmp = new Node();
        tmp->val = val;
        tmp->next = prevNode->next;
        tmp->prev = prevNode;
        prevNode->next->prev = tmp;
        prevNode->next = tmp;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        if(index<0||index>=size) return;
        struct Node* prevNode = getNode(index);
        struct Node* curNode = prevNode->next;
        prevNode->next = curNode->next;
        prevNode->next->prev = prevNode;
        delete curNode;
        size--;
    }
private:
    struct Node* head;
    struct Node* tail;
    int size;
    
    Node* getNode(int index){
        struct Node* cur;
        if(2*index>size){
            cur = tail;
            for(int i=0;i<size-index+1;i++){
                cur = cur->prev;
            }
        }else{
            cur = head;
            for(int i=0;i<index;i++){
                cur = cur->next;
            }
        }
        return cur;
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
