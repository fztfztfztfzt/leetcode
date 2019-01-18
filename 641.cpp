class MyCircularDeque {
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        size = 0;
        sizeMax = k;
        head = new Node();
        tail = new Node();
        head->next = tail;
        tail->prev = head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if(size>=sizeMax) return false;
        struct Node* tmp = new Node();
        tmp->val = value;
        tmp->next = head->next;
        tmp->prev = head;
        head->next->prev = tmp;
        head->next = tmp;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if(size>=sizeMax) return false;
        struct Node* tmp = new Node();
        tmp->val = value;
        tmp->next = tail;
        tmp->prev = tail->prev;
        tail->prev->next = tmp;
        tail->prev = tmp;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(size==0) return false;
        struct Node* tmp = head->next;
        tmp->next->prev = head;
        head->next = tmp->next;
        delete tmp;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if(size==0) return false;
        struct Node* tmp = tail->prev;
        tmp->prev->next = tail;
        tail->prev = tmp->prev;
        delete tmp;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if(size==0) return -1;
        return head->next->val;
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if(size==0) return -1;
        return tail->prev->val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return size==sizeMax;
    }
private:
    struct Node{
        int val;
        struct Node* next;
        struct Node* prev;
    };
    int size;
    int sizeMax;
    struct Node* head;
    struct Node* tail;
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * bool param_1 = obj.insertFront(value);
 * bool param_2 = obj.insertLast(value);
 * bool param_3 = obj.deleteFront();
 * bool param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * bool param_7 = obj.isEmpty();
 * bool param_8 = obj.isFull();
 */
