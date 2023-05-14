package Queue;

import Queue.CustomArrayQueue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayQueue<E> implements CustomArrayQueue<E> {


    private Object[] array;
    private int size;
    private int front;
    private int rear;

    public MyArrayQueue(){
        array = new Object[10];
        size = 0;
        front = 0;
        rear = 0;
    }

    @Override
    public boolean offer(E e) {

        if(size == array.length - 1){
            resize(array.length * 2);
        }
        rear = (rear+1) % array.length;
        array[rear] = e;
        size++;

        return true;
    }

    @Override
    public void resize(int newCapacity) {

        Object[] newArray = new Object[newCapacity];

        int idx = 1;
        for (int i = front+1; idx <= size; i++)
            newArray[idx++] = array[i % array.length];

        this.array = newArray;
        front = 0;
        rear = size;
    }

    @Override
    public E poll() {
        if(isEmpty())
            return null;

        front = (front+1) % array.length;
        E returnData = (E)array[front];
        array[front] = null;
        size--;
        if(size < array.length/2 && 10 < array.length/2)
            resize(array.length/2);
        return returnData;
    }

    @Override
    public E remove() {
        if(isEmpty())
            throw new NoSuchElementException("비어 있습니다.");

        return poll();
    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;

        return (E)array[(front + 1) % array.length];
    }

    @Override
    public E element() {
        if(isEmpty())
            throw new NoSuchElementException("비어 있습니다.");

        return peek();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        for(int i = front + 1; (i % array.length) != rear + 1; i++){
            if(array[i % array.length].equals(value))
                return true;
        }

        if(array[rear].equals(value))
            return true;

        return false;
    }

    @Override
    public void clear() {
        for(int i = front+1; i% array.length != front; i++)
            array[i%array.length] = null;

        size = 0;
        front = 0;
        rear = 0;
    }

    @Override
    public Object[] toArray() {
        return toArray(new Object[size]);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int iterSize = size;
        if(a.length < size)
          iterSize = a.length;


        int idx = 0;
        for(int i = front+1; idx < iterSize && i != rear+1; i++)
            a[idx++] = (T)array[i % array.length];

        return a;
    }

}
