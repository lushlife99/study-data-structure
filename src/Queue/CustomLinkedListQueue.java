package Queue;

public interface CustomLinkedListQueue<E> extends MyQueue<E> {
    E remove();
    E element();
    boolean isEmpty();
    boolean contains(Object value);
    void clear();
    <T> T[] toArray(T[] a);

}
