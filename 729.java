class MyCalendar {
    class Node{
        Node left,right;
        int start,end;
        public Node(){}
        public Node(int a,int b){
            start=a;end=b;
        }
    }
    Node root;
    boolean flag;
    public MyCalendar() {
        root = new Node();
    }
    
    public boolean book(int start, int end) {
        flag = true;
        root = add(root,start,end);
        return flag;
    }
    private Node add(Node node,int start,int end){
        if(flag==false) return node;
        if(node==null) return new Node(start,end);
        if(end<=node.start) node.left = add(node.left,start,end);
        else if(start>=node.end) node.right = add(node.right,start,end);
        else flag=false;
        return node;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */