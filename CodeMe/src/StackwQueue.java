import java.util.LinkedList;
import java.util.Queue;

public class StackwQueue {
    int size = 0;
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    void push(int x){
        size++;
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.peek());
            q1.remove();
        }
        //swapping queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }
    int top(){
        if(q1.isEmpty()) return -1;
        return q1.peek();
    }
    void pop(){
        if(q1.isEmpty()) return;
        q1.poll();
        size--;
    }
    int size(){
        return size;
    }
}
