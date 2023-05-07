public interface CustomArrayQueue<E> extends MyQueue<E> {
    void resize(int newCapacity);
    E remove();
    E element();
    int size();
    boolean isEmpty();
    boolean contains(Object value);
    void clear();
    Object[] toArray();
    <T> T[] toArray(T[] a);
}
