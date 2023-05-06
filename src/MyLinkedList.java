import java.util.NoSuchElementException;

public class MyLinkedList<E> implements CustomLinkedList<E>{

    private Node head;
    private Node tail;
    private int size;


    @Override
    public Node<E> search(int index) {
        if(isEmpty() || index < 0 || size  <= index)
            throw new IndexOutOfBoundsException("인덱스 오류");

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
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
        Node<E> search = search(index-1);
        node.next = search.next;
        search.next = node;
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
        head = node;
        size++;
    }

    @Override
    public void addLast(E value) {
        Node<E> node = new Node<>(value);

        if(isEmpty()){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public E remove() {
        if(isEmpty())
            throw new NoSuchElementException();

        E returnData = (E)head.data;
        size--;

        if(isEmpty()){
            head = null;
            tail = null;
            return returnData;
        }

        head = head.next;
        return returnData;
    }

    @Override
    public Object[] toArray() {
        return toArray((E[]) new Object[size]);
    }


    public E[] toArray(E[] a) {

        Node<E> node = head;
        int iterLength;

        if(size <= a.length)
            iterLength = size;
        else
            iterLength = a.length;

        for (int i = 0; i < iterLength; i++) {
            a[i] = (E) node.data;
            node = node.next;
        }
        return a;
    }



    @Override
    public E remove(int index) {
        if(index == 0){
            return remove();
        }

        Node<E> search = search(index-1);
        E returnData = (E)search.next.data;
        if(null == search.next)
            throw new IndexOutOfBoundsException("인덱스 오류");

        if(null != search.next.next){
            search.next = search.next.next;
        }
        else{
            search.next = null;
            tail = search;
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
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        search(index).data = value;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean contains(Object value) {
        if(isEmpty())
            throw new NoSuchElementException("없는 요소입니다.");

        Node node = head;
        while(node != null){
            if(node.data.equals(value))
                return true;

            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if(isEmpty())
            throw new NoSuchElementException("없는 요소입니다.");

        Node node = head;
        for(int index = 0; index < size; index++){
            if(node.data.equals(value)){
                return index;
            }
            node = node.next;
        }
        return -1;
    }


    @Override
    public boolean isEmpty() {
        if(size == 0)
            return true;

        return false;
    }

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

        public Node(){}

        public Node(E data){
            this.data = data;
        }

    }
}
