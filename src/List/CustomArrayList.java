package List;

public interface CustomArrayList<E> extends MyList<E> {
    void resize();
    void addLast(E value);
    void addFirst(E value);
    void set(int index, E value);
    int lastIndexOf(Object value);

}
