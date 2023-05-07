package List;

import List.CustomDoubleLinkedLst;

import java.util.NoSuchElementException;

public class MyDoubleLinkedList<E> implements MyList<E>, CustomDoubleLinkedLst<E> {


    private Node head;
    private Node tail;
    private int size;


    @Override
    public Node search(int index) {
        if(isEmpty() || index < 0 || index >= size)
            throw new IndexOutOfBoundsException("부적절한 인덱스");

        Node node;
        if(index < size/2) {

            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        else{
            node = tail;
            for(int i = size-1; i > index; i--){
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("부적절한 인덱스");

        if(index == size){
            add(value);
            return;
        }
        Node<E> node = new Node<>(value);
        Node search = search(index);
        node.prev = search.prev;
        node.next = search;
        search.prev.next = node;
        search.prev = node;
        size++;
    }
    @Override
    public void addFirst(E value) {

        Node node = new Node(value);
        if(isEmpty()){
            head = node;
            tail = node;
            size++;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    @Override
    public void addLast(E value) {
        Node node = new Node(value);

        if(isEmpty()){
            head = node;
            tail = node;
            size++;
            return;
        }

        if(size == 1){
            tail = node;
            head.next = node;
            node.prev = head;
            size++;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    @Override
    public E remove(int index) {
        Node search = search(index);
        E returnData = (E)search.data;
        if(index == 0){
            head = null;
            tail = null;
            size--;
            return returnData;
        }

        if(index == size-1){
            search.prev.next = null;
            tail = search.prev;
        }
        else{
            search.prev.next = search.next;
            search.next.prev = search.prev;
        }

        size--;
        return returnData;

    }

    @Override
    public boolean remove(Object value) {
        if(!contains(value))
            return false;

        int index = indexOf(value);
        remove(index);
        return true;
    }


    @Override
    public E remove() {
        if(isEmpty())
            throw new NoSuchElementException();

        Node<E> node = head;
        E returnData = (E)head.data;
        size--;

        if(isEmpty()){
            head = null;
            tail = null;
            return returnData;
        }

        head = head.next;
        head.prev = null;
        return returnData;
    }


    @Override
    public int lastIndexOf(Object o) {
        Node<E> node = tail;
        for(int index = size-1; index >=0; index--){
            if(node.data.equals(o))
                return index;

            node = node.prev;
        }
        throw new NoSuchElementException("없는 요소입니다.");
    }
    @Override
    public E get(int index) {
        return (E)search(index).data;
    }

    @Override
    public void set(int index, E value) {
        Node node = search(index);
        node.data = value;
    }

    @Override
    public boolean contains(Object value) {
        Node<E> node = head;

        for(int i = 0; i < size; i++){
            if(node.data.equals(value))
                return true;
        }

        return false;
    }

    @Override
    public int indexOf(Object value) {
        if(isEmpty())
            throw new NoSuchElementException("없는 요소입니다.");

        Node<E> node = head;
        for(int index = 0; index < size; index++){
            if(node.data.equals(value)){
                return index;
            }
            node = node.next;
        }
        throw new NoSuchElementException("없는 요소입니다.");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        if(size == 0)
            return true;

        return false;
    }

    @Override
    public <E> E[] toArray(E[] a) {

        int iterLength;
        if(size <= a.length)
            iterLength = size;
        else
            iterLength = a.length;

        Node<E> node = head;
        for (int i = 0; i < iterLength; i++) {
            a[i] = (E) node.data;
            node = node.next;
        }
        return a;
    }

    @Override
    public Object[] toArray() {
        return toArray((E[]) new Object[size]);
    }




    /**
     * clear 함수
     * for문을 돌려서 매 요소마다 null을 선언해주는것과
     * head와 tail을 모두 null을 선언해주는 방식이 있다.
     *
     * velog에 올림.
     */
    @Override
    public void clear() {
        Node node = head;
        Node nextNode = head;

        while(nextNode != null){
            node = nextNode;
            nextNode = node.next;
            node = null;
        }
        head = null;
        tail = null;
        size = 0;
    }


    class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(){

        }

        public Node(E data){
            this.data = data;
        }
    }

}
