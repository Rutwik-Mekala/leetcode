import java.util.ArrayList;

public class MyStack {
    int[] arr;
    int size;
    int cap;
    MyStack(int c){
        arr = new int[c];
        cap = c;
        size = 0;
    }
    boolean isFull(){
        return size==cap;
    }
    boolean isEmpty(){
        return size==0;
    }
    void push(int x){
        if(isFull()){
            System.out.println("Overflow error");
            return;
        }
        arr[size] = x;
        size++;
    }
    int pop(){
        if(isEmpty()){
            System.out.println("UnderFlow error");
            return -1;
        }
        int res = arr[size-1];
        size--;
        return res;
    }
    int peek(){
        return arr[size-1];
    }
    int size(){
        return size;
    }
    public static void main(String[] args) {
        MyStack s = new MyStack(5);
        s.push(5);
        s.push(15);
        s.push(25);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.size());
        s.push(35);
        System.out.println(s.size());
        System.out.println(s.isEmpty());
    }
}
class StackwArrayList{
    ArrayList<Integer> al = new ArrayList<>();
    void push(int x){
        al.add(x);
    }
    int pop(){
        int res = al.get(al.size()-1);
        al.remove(al.size()-1);
        return res;
    }
    int peek(){
        return al.get(al.size()-1);
    }
    boolean isEmpty(){
        return al.isEmpty();
    }
    int size(){
        return al.size();
    }
}
