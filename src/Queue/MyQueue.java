package Queue;

public interface MyQueue<E> {
    boolean offer(E e);
    E poll();
    E peek();

    Object[] toArray();

    int size();
}
