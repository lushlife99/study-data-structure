package Queue;

import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> implements CustomLinkedListQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    MyLinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E remove() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음.");

        return poll();
    }

    @Override
    public E poll() {
        if(isEmpty())
            return null;

        E returnData = head.data;
        head = head.next;
        size--;
        return returnData;
    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;

        return head.data;
    }

    @Override
    public E element() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음.");

        return peek();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        Node<E> node = head;

        while(node != null){
            if(node.data.equals(value))
                return true;

            node = node.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Node<E> node = head;
        int iterLength = a.length;
        if(size < a.length)
            iterLength = size;

        for(int i = 0; i < iterLength; i++){
            a[i] = (T)node.data;
            node = node.next;
        }
        return a;
    }

    @Override
    public boolean offer(E e) {
        Node<E> node = new Node<>(e);

        if(isEmpty())
            head = node;

        else{
            tail.next = node;
            tail = node;
        }
        return true;
    }





    @Override
    public Object[] toArray() {
        return toArray(new Object[size]);
    }

    @Override
    public int size() {
        return size;
    }

    class Node<E>{
        E data;
        Node<E> next;

        Node(){

        }
        Node(E data){
            this.data = data;
        }
    }


}
