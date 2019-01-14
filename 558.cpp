/*
// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;

    Node() {}

    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
public:
    Node* intersect(Node* quadTree1, Node* quadTree2) {
        //printf("%d %d\n",quadTree1->val,quadTree2->val);
        if(quadTree1->isLeaf){
            if(quadTree1->val) return quadTree1;
            else return quadTree2;
        }
        if(quadTree2->isLeaf){
            if(quadTree2->val) return quadTree2;
            else return quadTree1;
        }
        Node* root = new Node(false,true,NULL,NULL,NULL,NULL);
        Node* topLeft = intersect(quadTree1->topLeft, quadTree2->topLeft);
        Node* topRight = intersect(quadTree1->topRight, quadTree2->topRight);
        Node* bottomLeft = intersect(quadTree1->bottomLeft, quadTree2->bottomLeft);
        Node* bottomRight = intersect(quadTree1->bottomRight, quadTree2->bottomRight);
        if(topLeft->isLeaf&&topRight->isLeaf&&bottomLeft->isLeaf&&bottomRight->isLeaf){
            if(topLeft->val==true&&topRight->val==true&&bottomLeft->val==true&&bottomRight->val==true){
                root->val = true;
                root->isLeaf = true;
                return root;
            }
            if(topLeft->val==false&&topRight->val==false&&bottomLeft->val==false&&bottomRight->val==false){
                root->val = false;
                root->isLeaf = true;
                return root;
            }
        }
        root->val = false;
        root->isLeaf = false;
        root->topLeft = topLeft;
        root->topRight = topRight;
        root->bottomLeft = bottomLeft;
        root->bottomRight = bottomRight;
        return root;
    }
};
