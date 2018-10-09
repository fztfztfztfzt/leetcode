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
    vector<TreeNode*> allPossibleFBT(int N) {
        vector<TreeNode*> res;
        vector<TreeNode*> lres;
        vector<TreeNode*> rres;
        TreeNode* temp = new TreeNode(0);
        if(N%2==0) return res;
        if(N==1){
            res.push_back(temp);
            return res;
        }
        if(cache.find(N)!=cache.end()){
            return cache[N];
        }
        int r;
        for(int l=1;l<N-1;l+=2){
            r = N-1-l;
            lres = allPossibleFBT(l);
            rres = allPossibleFBT(r);
            for(int i=0;i<lres.size();i++){
                for(int j=0;j<rres.size();j++){
                    temp = new TreeNode(0);
                    temp->left = lres[i];
                    temp->right = rres[j];
                    res.push_back(temp);
                }
            }
        }
        cache[N] = res;
        return res;
    }
private:
    unordered_map<int,vector<TreeNode*>> cache;
};
