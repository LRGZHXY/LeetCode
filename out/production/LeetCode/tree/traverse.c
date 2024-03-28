#include <stddef.h>

//遍历二叉树

/**
 * Definition for a binary tree node.
   struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
struct TreeNode {
     int val;
     struct TreeNode *left;
     struct TreeNode *right;
 };
//前序遍历
int *preorder(struct TreeNode *root,int*ret, int *returnSize)
{
    if (root == NULL)
        return;
    ret[(*returnSize)++] = root->val;
    perOrder(root->left, ret, returnSize);
    preOrder(root->right, ret, returnSize);
}
int *preorderTraversal(struct TreeNode *root, int *returnSize)
{
    int *ret = (int *)malloc(sizeof(int) * 100);
    *returnSize = 0;
    preOrder(root, ret, returnSize);
    return ret;
}
//后序遍历
int* postorderTraversal(struct TreeNode* root, int* returnSize)
{
    int*ret=(int*)malloc(sizeof(int)*200);
    *returnSize=0;
    postOrder(root,ret,returnSize);
    return ret;
}
void postOrder(struct TreeNode*node,int*ret,int*returnSize)
{
    if(node==NULL)
        return;
    postOrder(node->left,ret,returnSize);
    postOrder(node->right,ret,returnSize);
    ret[(*returnSize)++]=node->val;
}
//中序遍历
int* inorderTraversal(struct TreeNode* root, int* returnSize) 
{
    int*ret=(int*)malloc(sizeof(int)*200);
    *returnSize=0;
    inOrder(root,ret,returnSize);
    return ret;
}
void inOrder(struct TreeNode*node,int*ret,int*returnSize)
{
    if(node==NULL)
        return;
    inOrder(node->left,ret,returnSize);
    ret[(*returnSize)++]=node->val;
    inOrder(node->right,ret,returnSize);
}