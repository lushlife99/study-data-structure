package Queue;

import List.MyDoubleLinkedList;

import java.util.NoSuchElementException;

public class MyDoubleLinkedDeque<E> implements CusTomDoubleLinkedDeque<E>{

    Node<E> head;
    Node<E> tail;
    int size;

    public MyDoubleLinkedDeque(){
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public boolean offerFirst(E value) {
        Node<E> node = new Node<>(value);
        if(isEmpty()) {
            head = tail = node;
        }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if(isEmpty())
            return offerFirst(value);

        Node<E> node = new Node<>(value);

        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty())
            return null;

        E returnData = head.data;
        size--;

        if(isEmpty())
            head = tail = null;

        else{
            head.next.prev = null;
            head = head.next;
        }

        return returnData;
    }

    @Override
    public E remove() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return pollFirst();
    }

    @Override
    public E removeFirst() {
        return remove();
    }

    @Override
    public E pollLast() {
        if(isEmpty())
            return null;

        E returnData = tail.data;

        size--;
        if(isEmpty())
            head = tail = null;

        else{
            tail.prev.next = null;
            tail = tail.prev;
        }

        return returnData;
    }

    @Override
    public E removeLast() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return pollFirst();
    }

    @Override
    public E peekFirst() {
        if(isEmpty())
            return null;

        return head.data;
    }

    @Override
    public E peekLast() {
        if(isEmpty())
            return null;

        return tail.data;
    }

    @Override
    public E element() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return head.data;
    }

    @Override
    public E getFirst() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return head.data;
    }

    @Override
    public E getLast() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return tail.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        Node<E> node = head;

        for(int i = 0; i < size; i++){
            if(node.data.equals(value))
                return true;

            node = node.next;
        }
        return false;
    }

    @Override
    public void clear() {
        Node<E> node = head;
        Node<E> nextNode = head;
        for(int i = 0; i < size; i++){
            node = nextNode;
            node.data = null;
            node.prev = null;
            nextNode = node.next;
            node.next = null;
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int iterLength = size;
        if(a.length < size)
            iterLength = a.length;

        Node<E> node = head;
        for(int i = 0; i < iterLength; i++){
            a[i] = (T)node.data;
            node = node.next;
        }
        return a;
    }

    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
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
        Node<E> prev;

        Node(){

        }
        Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
