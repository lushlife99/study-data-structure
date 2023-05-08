package Queue;

import java.util.Queue;

public interface CusTomDoubleLinkedDeque<E> extends MyQueue<E> {

    boolean offerFirst(E value);
    boolean offerLast(E value);
    E pollFirst();
    E remove();
    E removeFirst();
    E pollLast();
    E removeLast();
    E peekFirst();
    E peekLast();
    E element();
    E getFirst();
    E getLast();
    boolean isEmpty();
    boolean contains(Object value);
    void clear();
    <T> T[] toArray(T[] a);



}
