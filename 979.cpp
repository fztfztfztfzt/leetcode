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
    int distributeCoins(TreeNode* root) {
        if(!root) return 0;
        int left = need(root->left);
        int right = need(root->right);
        int res = 0;
        res += abs(left)+abs(right);
        res += distributeCoins(root->left);
        res += distributeCoins(root->right);
        return res;
    }
private:
    unordered_map<TreeNode*, int> count;
    int need(TreeNode* root){
        if(!root) return 0;
        if(count.find(root)!=count.end()) return count[root];
        int res = need(root->left)+need(root->right)+1-root->val;
        count[root] = res;
        return res;
    }
};
