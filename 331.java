class Solution {
    int i;
    public boolean isValidSerialization(String preorder) {
        i=0;
        String[] pre = preorder.split(",");
        return isValidSerialization(pre)&&(i==pre.length);
    }
    public boolean isValidSerialization(String[] preorder) {
        if(i>=preorder.length) return false;
        i++;
        if(preorder[i-1].equals("#")) return true;
        else return isValidSerialization(preorder)&&isValidSerialization(preorder);
    }
}