
public class LinkedL {
    ListNode head;
    static int size;
    LinkedL() {
        size = 0;
    }
    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            next = null;
            size++;
        }
        ListNode(){}
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
    public static ListNode reverseGroups(ListNode head, int k){
        ListNode curr = head;
        ListNode prev = null, next = null;
        int count = 0;
        while(curr!=null && count<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null){
            ListNode rest_head = reverseGroups(next,k);
            head.next = rest_head;
        }
        return prev;
    }
    public static void printList(ListNode head){
        ListNode currNode = head;
        while (currNode!=null){
            System.out.print(currNode.data+"-->");
            currNode = currNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode prev = root;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1!=null ? list1 : list2;
        return root.next;
    }
    public ListNode insertSort(ListNode head, int x){
        ListNode newNode = new ListNode(x);
        if(head==null){
            return newNode;
        }
        if(x<head.data){
            newNode.next = head;
            return newNode;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null){
            if(curr.data>x){
                break;
            }
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = newNode;
        newNode.next = curr;
        return head;
    }
    public void removeDuplicatedSorted(ListNode head){
        if(head==null || head.next==null){
            return;
        }
        ListNode curr = head;
        while(curr.next!=null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
    }
    public static void detectNremoveLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return;
        }
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
    public static ListNode segregate(ListNode head) {
        ListNode es = null, ee = null, os = null, oe = null;
        for(ListNode curr = head; curr!=null; curr = curr.next){
            int x = curr.data;
            if(x%2==0){
                if(es==null){
                    es = curr;
                    ee = es;
                }else{
                    ee.next = curr;
                    ee = ee.next;
                }
            }else{
                if(os==null){
                    os = curr;
                    oe = os;
                }else{
                    oe.next = curr;
                    oe = oe.next;
                }
            }
        }
        if(es==null || os==null) return head;
        ee.next = os;
        oe.next = null;
        return es;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(10);
        head.next=new ListNode(20);
        head.next.next=new ListNode(30);
        head.next.next.next=new ListNode(40);
        head.next.next.next.next=new ListNode(50);
        head.next.next.next.next.next=new ListNode(60);
        head.next.next.next.next.next.next=new ListNode(70);
        printList(head);
        head=reverseGroups(head,2);
        printList(head);
    }

}
