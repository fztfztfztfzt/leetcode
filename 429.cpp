/*
// Definition for a Node.
class Node {
public:
    int val = NULL;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if(root==NULL) return res;
        vector<Node*> now;
        vector<int> next_val;
        now.push_back(root);
        next_val.push_back(root->val);
        while(now.size()!=0){
            res.push_back(next_val);
            vector<Node*> next;
            next_val.clear();
            for(auto node : now){
                for(auto child : node->children){
                    next.push_back(child);
                    next_val.push_back(child->val);
                }
            }
            now = next;   
        }
        return res;
    }
};
