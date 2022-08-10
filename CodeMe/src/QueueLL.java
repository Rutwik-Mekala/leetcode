import java.util.LinkedList;

public class QueueLL {
    public static void main(String[] args) {
        QueueDS q = new QueueDS();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.printQueue();
        q.dequeue();
        q.enqueue(4);
        q.printQueue();
    }
}

class QueueDS {
    Node front;
    Node rear;
    int size;
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
        }
    }
    QueueDS(){
        size = 0;
    }
    boolean isEmpty(){
        return size==0;
    }
    void enqueue(int x){
        Node node = new Node(x);
        if(front==null){
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
        size++;
    }
    void dequeue(){
        if(isEmpty()) return;
        front = front.next;
        if(front==null) rear = null;
        size--;
    }
    void printQueue(){
        Node curr = front;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
