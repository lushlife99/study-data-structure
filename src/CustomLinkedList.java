public interface CustomLinkedList<E> extends MyList<E>{

    MyLinkedList.Node search(int index); // Node를 내부클래스나 외부클래스로 만드세여.
    void addFirst(E value);
    void addLast(E value);
    E remove();
    Object[] toArray();


}
