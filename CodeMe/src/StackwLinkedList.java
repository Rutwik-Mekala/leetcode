public class StackwLinkedList {
    //With doubly linkedlist
    Node head;
    Node tail;
    int size;
    StackwLinkedList(){
        size=0;
    }
   static class Node{
       int data;
       Node next;
       Node prev;
       Node(int d){
           this.data = d;
           next = null;
           prev = null;
       }
   }
   boolean isEmpty(){
       return size==0;
   }
   void push(int x){
       Node newNode = new Node(x);
       if(isEmpty()){
           head = tail = newNode;
           size++;
           return;
       }
       tail.next = newNode;
       newNode.prev = tail;
       tail = newNode;
       size++;
   }
   int pop(){
       int res = tail.data;
       tail.prev.next = tail.next;
       tail.next.prev = tail.prev;
       size--;
       return res;
   }
   int peek(){
       return tail.data;
   }
   int size(){
       return size;
   }
    public static void main(String[] args) {
        StackLL s = new StackLL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.peek());
        System.out.println(s.size());
    }
}
class StackLL{
    //Using Singly Linkedlist
    //Here we add and delete elements to the head of the LL
    Node head;
    int size;
    StackLL(){
        size=0;
    }
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            next = null;
        }
    }
    boolean isEmpty(){
        return size==0;
    }
    void push(int x){
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
    }
    int pop(){
        if(isEmpty()){
            return Integer.MAX_VALUE;
        }
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }
    int peek(){
        if(isEmpty()){
            return Integer.MAX_VALUE;
        }
        return head.data;
    }
    int size(){
        return size;
    }
}
