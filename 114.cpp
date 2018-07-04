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
    void flatten(TreeNode* root) {
        if(root==NULL) return;
        TreeNode* left = root->left;
        TreeNode* right = root->right;
        TreeNode* next = flatten(left,root);
        flatten(right,next);
    }
private:
    TreeNode* flatten(TreeNode* root, TreeNode* pre){
        pre->right = root;
        pre->left = NULL;
        if(root==NULL) return pre;
        //printf("%d %d\n",root->val,pre->val);
        TreeNode* right = root->right;
        TreeNode* left = root->left;
        TreeNode* next = flatten(left,root);
        next = flatten(right,next);
        return next;
    }
};