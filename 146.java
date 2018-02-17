class LRUCache {
    class ListNode {
        int val;
        int key;
        ListNode pre;
        ListNode next;
        ListNode(){}
        ListNode(int k,int v){
            val = v;
            key = k;
        }
    }
    Map<Integer,ListNode> map;
    int cap;
    int CAPACITY;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        cap = 0;
        CAPACITY = capacity;
        map = new HashMap<>();
        head  = new ListNode();
        head.pre = null;
        tail = new ListNode();
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if(node==null) return -1;
        else moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = map.get(key);
        if(node==null){
            ListNode newNode = new ListNode(key,value);
            map.put(key,newNode);
            newNode.pre = head;
            newNode.next = head.next;
            head.next.pre = newNode;
            head.next = newNode;
            ++cap;
            if(cap>CAPACITY){
                map.remove(tail.pre.key);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
                --cap;
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }
    private void moveToHead(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */