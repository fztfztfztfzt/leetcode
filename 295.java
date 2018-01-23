class MedianFinder {
    class Heap {
        List<Integer> data;
        int size;
        public Heap() {
            size=0;
            data = new ArrayList<Integer>();
        }
        public void push(int d){
            data.add(d);
            data.set(size++,d);
            up(size-1);
        }
        public int top(){
            return data.get(0);
        }
        public int pop(){
            int temp = data.get(0);
            data.set(0,data.get(--size));
            down(0);
            return temp;
        }
        private void down(int i){
            if(2*i+1>=size) return;
            else if(2*i+1==size-1){
                if(data.get(i)>data.get(2*i+1)){
                    int temp = data.get(i);
                    data.set(i,data.get(2*i+1));
                    data.set(2*i+1,temp);
                }
            }else{
                if(data.get(2*i+1)<data.get(2*i+2)){
                    int temp = data.get(i);
                    data.set(i,data.get(2*i+1));
                    data.set(2*i+1,temp);
                    down(2*i+1);
                }else{
                    int temp = data.get(i);
                    data.set(i,data.get(2*i+2));
                    data.set(2*i+2,temp);
                    down(2*i+2);
                }
            }
            return;
        }
        private void up(int i){
            if(i>0){
                int father = (i-1)/2;
                if(data.get(father)>data.get(i)){
                    int temp = data.get(i);
                    data.set(i,data.get(father));
                    data.set(father,temp);
                    up(father);
                }
            }
        }
    }
    Heap small,large;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new Heap();
        large = new Heap();
    }
    
    public void addNum(int num) {
        small.push(-num);
        large.push(-small.pop());
        if(small.size<large.size){
            small.push(-large.pop());
        }
        //System.out.println(small.data);
        //System.out.println(large.data);
    }
    
    public double findMedian() {
        int len = small.size + large.size;  
        if(len%2==1) return -small.top();  
        return (-small.top()+large.top())/2.0;  
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */