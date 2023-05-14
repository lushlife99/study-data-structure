package Queue;

import Heap.MyHeap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueue<E> extends MyHeap<E> implements MyQueue<E>{

    @Override
    public boolean offer(E e) {
        add(e);
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())
            return null;

        return remove();
    }

    @Override
    public E peek() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return (E)array[1];
    }

    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    public int size() {
        return size;
    }

    public <T> T[] toArray(T[] a){
        int iterSize = a.length;
        if(size < a.length)
            iterSize = size;

        for(int i = 1; i <= iterSize; i++)
            a[i-1] = (T)array[i];

        return a;
    }

    public void clear(){
        for(int i = 1; i < size; i++)
            array[i] = null;

        array = new Object[10];
        size = 0;
    }

    public boolean contains(Object value){
        for(int i = 1; i <= size; i++){
            if(value.equals(array[i]))
                return true;

        }
        return false;
    }
    public boolean isEmpty(){

        return size == 0;
    }
}
