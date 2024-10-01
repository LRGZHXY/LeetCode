package LinkedList;

//双链表
class ListNode{
    int val;
    ListNode next,prev;
    ListNode(){}
    ListNode(int val){
        this.val=val;
    }
}

class MyLinkedList {
    int size;
    ListNode head,tail;

    public MyLinkedList() {
        this.size=0;
        this.head=new ListNode(0);
        this.tail=new ListNode(0);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int index) {
        if(index>=size){
            return -1;
        }
        ListNode cur=this.head;
        if(index>=size/2){
            cur=tail;
            for(int i=0;i<size-index;i++){
                cur=cur.prev;
            }
        }else{
            for(int i=0;i<=index;i++){
                cur=cur.next;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        ListNode pre=this.head;
        for(int i=0;i<index;i++){
            pre=pre.next;
        }
        ListNode newNode=new ListNode(val);
        newNode.next=pre.next;
        pre.next.prev=newNode;
        newNode.prev=pre;
        pre.next=newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if(index>=size){
            return;
        }
        ListNode pre=this.head;
        for(int i=0;i<index;i++){
            pre=pre.next;
        }
        pre.next.next.prev=pre;
        pre.next=pre.next.next;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */