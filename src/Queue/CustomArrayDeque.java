package Queue;

import java.util.Queue;

public interface CustomArrayDeque<E> extends MyQueue<E> {

    void resize(int newCapacity);
    boolean offerLast(E item);
    boolean offerFirst(E item);
    E pollFirst();
    E remove();
    E removeFirst();
    E pollLast();
    E removeLast();
    E peekFirst();
    E peekLast();
    E getFirst();
    E getLast();
    boolean isEmpty();
    boolean contains(Object value);
    void clear();
    <T> T[] toArray(T[] a);

}
