import Set.MyHashSet;

public class Main{
    public static void main(String[] args) {
        MyHashSet<Integer> myHashSet = new MyHashSet<Integer>();
        for(int i = 0; i < 10; i++){
            Integer integer = i*1512%13;
            myHashSet.add(integer);
        }
    }
}