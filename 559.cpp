/*
// Definition for a Node.
class Node {
public:
    int val;
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
    int maxDepth(Node* root) {
        if(root==NULL) return 0;
        queue<Node*> Queue;
        int depth = 0;
        int size = 0;
        Node* temp;
        Queue.push(root);
        while(!Queue.empty()){
            size = Queue.size();
            for(int i=0;i<size;i++){
                temp = Queue.front();
                Queue.pop();
                for (auto child : temp->children){
                    Queue.push(child);
                }
            }
            depth++;
        }
        return depth;
    }
};