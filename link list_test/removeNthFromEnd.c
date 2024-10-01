//删除链表的倒数第N个结点
#include <stdio.h>
//c语言单链表的定义
 struct ListNode {
  int val;
  struct ListNode *next;
 };

 ///
 struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode*dummyhead=(struct ListNode*)malloc(sizeof(struct ListNode));
    dummyhead->next=head;
    struct ListNode*fast=dummyhead;
    struct ListNode*slow=dummyhead;

    n++;
    while(n--&&fast!=NULL){
        fast=fast->next;
    }
    while(fast!=NULL){
        fast=fast->next;
        slow=slow->next;
    }
    slow->next=slow->next->next;

    return dummyhead->next;
}

struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    //定义虚拟头节点dummy 并初始化使其指向head
    struct ListNode* dummy = malloc(sizeof(struct ListNode));
    dummy->val = 0;
    dummy->next = head;
    //定义 fast slow 双指针
    struct ListNode* fast = head;
    struct ListNode* slow = dummy;

    for (int i = 0; i < n; ++i) {
        fast = fast->next;
    }
    while (fast) {
        fast = fast->next;
        slow = slow->next;
    }
    slow->next = slow->next->next;//删除倒数第n个节点
    head = dummy->next;
    free(dummy);//删除虚拟节点dummy
    return head;
}

