/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* recoverFromPreorder(string S) {
        pos = 0;
        return recoverFromPreorder(S,0);
    }
private:
    int pos;
    TreeNode* recoverFromPreorder(const string& S,int deep){
        int deep2 = getDeep(S);
        if(deep2!=deep){
            pos-=deep2;
            return NULL;
        }
        int val = getVal(S);
        printf("%d %d\n",deep,val);
        TreeNode *tmp = new TreeNode(val);
        if(pos>=S.size()) return tmp;
        tmp->left = recoverFromPreorder(S,deep+1);
        tmp->right = recoverFromPreorder(S,deep+1);
        return tmp;
    }
    int getDeep(const string& S){
        int res = 0;
        char tmp = S[pos];
        while(tmp>'9'||tmp<'0'&&pos<S.size()){
            pos++;
            tmp = S[pos];
            res++;
        }
        return res;
    }
    int getVal(const string& S){
        int res = 0;
        char tmp = S[pos];
        while(tmp<='9'&&tmp>='0'&&pos<S.size()){
            pos++;
            res = 10*res+(tmp-'0');
            tmp = S[pos];
        }
        return res;
    }
};