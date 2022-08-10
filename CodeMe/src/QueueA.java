public class QueueA {
    public static void main(String[] args) {
        Queue q = new Queue(6);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.printQueue();
        q.dequeue();
        q.enqueue(4);
        q.dequeue();
        q.printQueue();
    }
}
//implementation using circular array. more efficient
class Queue{
    int cap,size;
    int front,rear;
    int[] arr;
    Queue(int cap){
        this.cap = cap;
        arr = new int[cap];
        size = 0;
        front = -1; rear = -1;
    }
    boolean isEmpty(){
        return front==-1 && rear==-1;
    }
    boolean isFull(){
        return (rear+1)%cap==front;
    }
    void enqueue(int x){
        if(front==-1){
            front = 0;
        }
        rear = (rear+1)%cap;
        if(isFull()){
            System.out.println("Queue is full. Can't enqueue");
            return;
        }
        arr[rear] = x;
        size++;
    }
    void dequeue(){
        if(isEmpty()){
            System.out.println("Cannot dequeue an empty queue");
            return;
        }
        int temp = arr[front];
        front = (front+1)%cap;
        size--;
        //return temp;
    }

    int getFront(){
        return isEmpty() ? -1 : arr[front];
    }
    int getRear(){
        return isEmpty() ? -1 : arr[rear];
    }
    void printQueue(){
        int i = front;
        while(i!=rear){
            System.out.print(arr[i]+" ");
            i++;
        }
        System.out.print(arr[rear]);
        System.out.println();
    }
    int size(){
        return size;
    }
}
//simple but inefficient implementation below

//class Queue{
//    int size,cap;
//    int[] arr;
//    Queue(int cap){
//        this.cap = cap;
//        this.size = 0;
//        arr = new int[cap];
//    }
//    void enqueue(int x){
//        if(isFull()){
//            System.out.println("Size is full. Can't add");
//            return;
//        }
//        arr[size] = x;
//        size++;
//    }
//    int dequeue(){
//        if(isEmpty()){
//            System.out.println("Queue is empty");
//            return -1;
//        }
//        int temp = arr[0];
//        for(int i=1; i<size; i++){
//            arr[i-1] = arr[i];
//        }
//        size--;
//        return temp;
//    }
//    int getFront(){
//        return isEmpty() ? -1 : arr[0];
//    }
//    int getRear(){
//        return isEmpty() ? -1 : arr[size-1];
//    }
//    boolean isFull(){
//        return size==cap;
//    }
//    boolean isEmpty(){
//        return size==0;
//    }
//    int size(){
//        return size;
//    }
//}

