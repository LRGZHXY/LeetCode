//反转链表
#include <stdio.h>
struct ListNode {
     int val;
   struct ListNode *next;
};

/// 
struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode*tmp;
    struct ListNode*pre=NULL;
    struct ListNode*cur=head;
    while(cur!=NULL){
        tmp=cur->next;
        cur->next=pre;
        pre=cur;
        cur=tmp;
    }
    return pre;
}

//双指针法
struct ListNode* reverseList(struct ListNode* head){
    //保存cur的下一个结点
    struct ListNode* temp;
    //pre指针指向前一个当前结点的前一个结点
    struct ListNode* pre = NULL;
    //用head代替cur，也可以再定义一个cur结点指向head。
    while(head) {
        //保存下一个结点的位置
        temp = head->next;
        //翻转操作
        head->next = pre;
        //更新结点
        pre = head;
        head = temp;
    }
    return pre;
}

//递归法
struct ListNode* reverse(struct ListNode* pre, struct ListNode* cur) {
    if(!cur)
        return pre;
    struct ListNode* temp = cur->next;
    cur->next = pre;
    //将cur作为pre传入下一层
    //将temp作为cur传入下一层，改变其指针指向当前cur
    return reverse(cur, temp);
}

struct ListNode* reverseList(struct ListNode* head){
    return reverse(NULL, head);
}

