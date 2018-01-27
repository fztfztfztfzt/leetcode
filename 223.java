class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(E>C||G<A||H<B||F>D) return (C-A)*(D-B)+(G-E)*(H-F);
        int x1 = Math.max(A,E);
        int x2 = Math.min(C,G);
        int y1 = Math.max(B,F);
        int y2 = Math.min(D,H);
        return (C-A)*(D-B)+(G-E)*(H-F)-(x2-x1)*(y2-y1);
    }
}