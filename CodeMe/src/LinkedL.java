
public class LinkedL {
    ListNode head;
    static int size;
    LinkedL() {
        size = 0;
    }
    public class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            next = null;
            size++;
        }
    }
    public void add(int data){
        ListNode newNode = new ListNode(data);
        if(head==null){
            head = newNode;
            return;
        }
        ListNode currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    //leetcode 19
    //Given the head of a linked list, remove the nth node from the end of the list and return its head.
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode time = head;
        int size = 0;
        while(time!=null){
            time = time.next;
            size++;
        }
        if(size==1 && n==1){
            return null;
        }
        ListNode prev = head;
        for(int i=1; i<size-n; i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
    //leetcode 141
    //Given head, the head of a linked list, determine if the linked list has a cycle in it.
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
    //leetcode 206
    //Given the head of a singly linked list, reverse the list, and return the reversed list.
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode prevNode = head;
        ListNode currNode = head.next;
        while(currNode!=null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
        return head;
    }
    public void printList(ListNode head){
        ListNode currNode = head;
        while (currNode!=null){
            System.out.print(currNode.data+"-->");
            currNode = currNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedL l = new LinkedL();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.printList(l.head);
        l.removeNthFromEnd(l.head,2);
        l.printList(l.head);
    }
}
