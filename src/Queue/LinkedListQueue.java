package Queue;

import java.util.Queue;

public interface LinkedListQueue<E> extends MyQueue<E> {
    E remove();
    E element();
    boolean isEmpty();
    boolean contains(Object value);
    void clear();
    <T> T[] toArray(T[] a);

}
