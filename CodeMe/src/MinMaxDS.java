import java.util.ArrayDeque;

public class MinMaxDS {
    ArrayDeque<Integer> ad;
    MinMaxDS(){
        ad = new ArrayDeque<>();;
    }

    void insertMin(int x){
        ad.offerFirst(x);
    }
    void insertMax(int x){
        ad.offerLast(x);
    }
    int getMin(){
        return ad.peekFirst();
    }
    int getMax(){
        return ad.peekLast();
    }
    int extractMin(){
        return ad.pollFirst();
    }
    int extractMax(){
        return ad.pollLast();
    }
}
