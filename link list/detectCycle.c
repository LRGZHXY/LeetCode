//环形链表
#include <stdio.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};

///
struct ListNode *detectCycle(struct ListNode *head)
{
    struct ListNode *fast = head;
    struct ListNode *slow = head;

    while (fast != NULL && fast->next != NULL)
    {
        fast = fast->next->next;
        slow = slow->next;
        if (fast == slow)
        {
            struct ListNode *ptr1 = head;
            struct ListNode *ptr2 = fast;
            while (ptr1 != ptr2)
            {
                ptr1 = ptr1->next;
                ptr2 = ptr2->next;
            }
            return ptr1;
        }
    }
    return NULL;
}

typedef struct ListNode ListNode;
ListNode *detectCycle(ListNode *head)
{
    ListNode *fast = head, *slow = head;
    while (fast && fast->next)
    {
        // 这里判断两个指针是否相等，所以移位操作放在前面
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast)
        { // 相交，开始找环形入口：分别从头部和从交点出发，找到相遇的点就是环形入口
            ListNode *f = fast, *h = head;
            while (f != h)
                f = f->next, h = h->next;
            return h;
        }
    }
    return NULL;
}