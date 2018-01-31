class Solution {
    public boolean isIdealPermutation(int[] A) {
        for(int i=0;i<A.length;i++) if(Math.abs(i-A[i])>1) return false;
        return true;
    }
}