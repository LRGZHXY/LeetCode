//i移除链表元素
#include <stdio.h>
struct ListNode{
    int val;
    struct ListNode*next;
};

struct ListNode* removeElements(struct ListNode* head, int val) {
    struct ListNode* temp;
    while(head!=NULL&&head->val==val)
    {
        temp=head;
        head=head->next;
        free(temp);
    }
    struct ListNode* cur=head;
    while(cur!=NULL&&cur->next!=NULL)
    {
        if(cur->next->val==val)
        {
            temp=cur->next;
            cur->next=temp->next;
            free(temp);
        }
        else
        {
            cur=cur->next;
        }
        
    }
    return head;
}