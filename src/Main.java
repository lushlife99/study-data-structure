
public class Main{
    public static void main(String[] args) {
        String s = "abcd";
        s += "efgh";
        System.out.println(s);


    }
}

class B{
    int num;
}

class A implements Comparable<A>{
    int num;

    public A(int num){
        this.num = num;
    }

    @Override
    public int compareTo(A o) {
        return this.num - o.num;
    }
}