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
    void recoverTree(TreeNode* root) {
        vector<int> vals;
        vector<TreeNode*> nodes;
        helper(vals,nodes,root);
        sort(vals.begin(),vals.end());
        for(int i=0;i<nodes.size();i++){
            nodes[i]->val = vals[i];
        }
        return;
    }
private:
    void helper(vector<int>& vals, vector<TreeNode*>& nodes, TreeNode* root){
        if(root==NULL) return;
        helper(vals,nodes,root->left);
        vals.push_back(root->val);
        nodes.push_back(root);
        helper(vals,nodes,root->right);
        return;
    }
};

class Solution {
public:
    void recoverTree(TreeNode* root) {
        TreeNode *pre=nullptr, *cur=root, *first=nullptr, *second=nullptr;
        while(cur){
            if(cur->left){
                TreeNode *tmp = cur->left;
                while(tmp->right&&tmp->right!=cur) tmp = tmp->right;
                if(!tmp->right){
                    tmp->right = cur;
                    cur = cur->left;
                    continue;
                }else{
                    tmp->right = NULL;
                }
            }
            if(pre&&cur->val<pre->val){
                if(!first) first = pre;
                second = cur;
            }
            pre = cur;
            cur = cur->right;
        }
        swap(first->val,second->val);
    }
};