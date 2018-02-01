class RandomizedCollection {
    Map<Integer,Set<Integer>> map;
    List<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            Set<Integer> temp = new HashSet<>();
            temp.add(list.size());
            map.put(val,temp);
            list.add(val);
            return true;
        }else{
            Set<Integer> temp = map.get(val);
            temp.add(list.size());
            map.put(val,temp);
            list.add(val);
            return false;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int pos = map.get(val).iterator().next();
            map.get(val).remove(pos);
            if(pos<list.size()-1){
                int l = list.get(list.size()-1);
                list.set(pos,l);
                map.get(l).remove(list.size()-1);
                map.get(l).add(pos);
            }
            list.remove(list.size()-1);
            if(map.get(val).isEmpty()) map.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */