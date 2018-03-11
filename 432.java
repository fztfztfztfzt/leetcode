class AllOne {
    class DLinkedNode {
        int val;
        Set<String> set;
        DLinkedNode pre,next;
        DLinkedNode(){}
        DLinkedNode(int v){
            val = v;
            set = new HashSet<String>();
        }
    }
    Map<String,DLinkedNode> map;
    DLinkedNode max;
    DLinkedNode min;
    /** Initialize your data structure here. */
    public AllOne() {
        max = new DLinkedNode(Integer.MAX_VALUE);
        min = new DLinkedNode(0);
        map = new HashMap<>();
        max.pre = min;
        min.next = max;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!map.containsKey(key)){
            if(min.next.val!=1){
                DLinkedNode temp = new DLinkedNode(1);
                temp.set.add(key);
                map.put(key,temp);
                temp.next = min.next;
                temp.pre = min;
                min.next.pre = temp;
                min.next = temp;
            }else{
                min.next.set.add(key);
                map.put(key,min.next);
            }
        }else{
            DLinkedNode temp = map.get(key);
            if(temp.val+1==temp.next.val){
                temp.set.remove(key);
                temp.next.set.add(key);
                map.put(key,temp.next);
                if(temp.set.size()==0){
                    temp.pre.next = temp.next;
                    temp.next.pre = temp.pre;
                }
            }else{
                if(temp.set.size()==1){temp.val+=1;return;}
                temp.set.remove(key);
                DLinkedNode t = new DLinkedNode(temp.val+1);
                t.set.add(key);
                map.put(key,t);
                t.next = temp.next;
                t.pre = temp;
                temp.next.pre = t;
                temp.next = t;
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            DLinkedNode temp = map.get(key);
            if(temp.val==1){
                temp.set.remove(key);
                if(temp.set.size()==0){
                    min.next = temp.next;
                    temp.next.pre = min;
                }
                map.remove(key);
                
            }else{
                if(temp.val-1==temp.pre.val){
                    temp.set.remove(key);
                    temp.pre.set.add(key);
                    map.put(key,temp.pre);
                    if(temp.set.size()==0){
                        temp.pre.next = temp.next;
                        temp.next.pre = temp.pre;
                    }
                }else{
                    if(temp.set.size()==1){temp.val-=1;return;}
                    temp.set.remove(key);
                    DLinkedNode t = new DLinkedNode(temp.val-1);
                    t.set.add(key);
                    map.put(key,t);
                    t.next = temp;
                    t.pre = temp.pre;
                    temp.pre.next = t;
                    temp.pre = t;
                }
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        Iterator it = max.pre.set.iterator();
        if(it.hasNext()) return (String)it.next();
        else return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        Iterator it = min.next.set.iterator();
        if(it.hasNext()) return (String)it.next();
        else return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */