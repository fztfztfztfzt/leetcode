class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        for(String name : p){
            if(name.equals(".")) continue;
            if(name.equals("")) continue;
            if(name.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(name);
        }
        String sb = "";
        while(!stack.isEmpty()){
            sb = "/"+stack.pop()+sb;
        }
        return sb.equals("")?"/":sb;
    }
}