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
    TreeNode* pruneTree(TreeNode* root) {
        if(root==NULL) return root;
        TreeNode* left = pruneTree(root->left);
        TreeNode* right = pruneTree(root->right);
        if(left==NULL&&right==NULL&&root->val==0) return NULL;
        root->left = left;
        root->right = right;
        return root;
    }
};