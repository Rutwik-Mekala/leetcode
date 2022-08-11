public class DequewArray {
    int size,cap;
    int front;
    int[] arr;
    DequewArray(int c){
        this.cap = c;
        front = 0;
        arr = new int[cap];
        size=0;
    }
    boolean isFull(){
        return size==cap;
    }
    boolean isEmpty(){
        return size==0;
    }
    void insertRear(int x){
        if(isFull()){
            System.out.println("Cannot add to full queue");
            return;
        }
        int rear = getRear();
        rear = (rear+1)%cap;
        arr[rear] = x;
        size++;
    }
    void insertFront(int x){
        if(isFull()) {
            System.out.println("Cannot add to full queue");
            return;
        }
        front = (front-1+cap)%cap;
        arr[front] = x;
        size++;
    }
    void deleteRear(){
        if(isEmpty()){
            System.out.println("Cannot delete from an empty queue");
            return;
        }
        int rear = getRear();
        arr[rear] = 0;
        //rear = (rear-1+cap)%cap;
        size--;
    }
    void deleteFront(){
        if(isEmpty()){
            System.out.println("Cannot delete from an empty queue");
            return;
        }
        arr[front] = 0;
        front = (front+1)%cap;
        size--;
    }
    int getFront(){
        return isEmpty() ? -1 : front;
    }
    int getRear(){
        return isEmpty() ? -1 : (front+size-1)%cap;
    }
    void printDeque(){
//        int curr = front;
//        while(curr!=rear){
//            System.out.print(arr[curr]+" ");
//            curr = (curr+1)%cap;
//        }
//        System.out.print(arr[rear]);
//        System.out.println();
        for(int i=0; i<cap; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DequewArray dq = new DequewArray(4);
        dq.insertFront(10);
        //System.out.println(dq.getFront());
        dq.insertRear(20);
        //System.out.println(dq.getRear());
        dq.insertRear(30);
        //System.out.println(dq.getRear());
        dq.deleteFront();
        dq.deleteRear();
        dq.printDeque();
    }
}

