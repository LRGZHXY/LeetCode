//链表相交
#include <stdio.h>
struct ListNode{
    int val;
    struct ListNode*next;
};

/// 
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    struct ListNode*str;
    struct ListNode*longer;
    int lenA=0,lenB=0,gap=0;

    str=headA;
    while(str!=NULL){
        lenA++;
        str=str->next;
    }
    str=headB;
    while(str!=NULL){
        lenB++;
        str=str->next;
    }

    if(lenA>lenB){
        longer=headA;
        str=headB;
        gap=lenA-lenB;
    }
    else{
        longer=headB;
        str=headA;
        gap=lenB-lenA;
    }

    while(gap--){
        longer=longer->next;
    }

    while(longer!=NULL){
        if(longer==str){
            return longer;
        }
        longer=longer->next;
        str=str->next;
    }
    return NULL;
}

typedef struct ListNode ListNode;
ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    ListNode *l = NULL, *s = NULL;
    int lenA = 0, lenB = 0, gap = 0;
    // 求出两个链表的长度
    s = headA;
    while (s) {
        lenA ++;
        s = s->next;
    }
    s = headB;
    while (s) {
        lenB ++;
        s = s->next;
    }

    // 求出两个链表长度差
    if (lenA > lenB) {
        l = headA, s = headB;
        gap = lenA - lenB;
    } else {
        l = headB, s = headA;
        gap = lenB - lenA;
    }

    // 尾部对齐
    while (gap--) l = l->next;
    // 移动，并检查是否有相同的元素
    while (l) {
        if (l == s) return l;
        l = l->next, s = s->next;
    }

    return NULL;
}