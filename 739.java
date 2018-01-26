class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] next = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            int num = temperatures[i];
            while(!stack.isEmpty()&&temperatures[stack.peek()]<num){
                next[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return next;
    }
}