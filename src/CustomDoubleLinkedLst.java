public interface CustomDoubleLinkedLst<E> extends MyList<E>{
    MyDoubleLinkedList.Node search(int index);
    public void addFirst(E value);
    public void addLast(E value);
    E remove();
    int lastIndexOf(Object o);
    Object[] toArray();
    <T> T[] toArray(T[] a);

}
