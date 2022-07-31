import java.util.Arrays;

class MyHash {
    int size;
    int cap;
    int[] table;
    MyHash(int size){
        this.size = size;
        table = new int[size];
        cap=0;
    }
    public void doubleHashingInsert(int key){
        if(cap==size){
            System.out.println("Cant insert when table is full");
        }
        int probe = key%size;
        int offset = (size-1) - ((key)%(size-1));
        while(table[probe]!=0){
            probe = (probe+offset)%size;
        }
        table[probe] = key;
        cap++;
    }
    public boolean search(int key){
        int probe = key%size;
        int c = 0;
        int offset = (size-1) - ((key)%(size-1));
        if(table[probe]==key){
            return true;
        }else{
            while(table[probe]!=key){
                probe = (probe+offset)%size;
                c++;
                if(c==size) return false;
            }
            return true;
        }

    }
    public String toString(){
        return Arrays.toString(table);
    }

}

