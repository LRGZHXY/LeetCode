//两两交换链表中的结点
#include <stdio.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};

///
struct ListNode *swapPairs(struct ListNode *head)
{
    struct ListNode *dummyhead = (struct ListNode *)malloc(sizeof(struct ListNode));
    dummyhead->next = head;
    struct ListNode *cur = dummyhead;
    while (cur->next != NULL && cur->next->next != NULL)
    {
        struct ListNode *tmp1 = cur->next;
        struct ListNode *tmp2 = cur->next->next->next;

        cur->next = cur->next->next;
        cur->next->next = tmp1;
        tmp1->next = tmp2;

        cur = cur->next->next;
    }
    return dummyhead->next;
}

// 迭代版本
struct ListNode *swapPairs(struct ListNode *head)
{
    // 使用双指针避免使用中间变量
    typedef struct ListNode ListNode;
    ListNode *fakehead = (ListNode *)malloc(sizeof(ListNode));
    fakehead->next = head;
    ListNode *right = fakehead->next;
    ListNode *left = fakehead;
    while (left && right && right->next)
    {
        left->next = right->next;
        right->next = left->next->next;
        left->next->next = right;
        left = right;
        right = left->next;
    }
    return fakehead->next;
}