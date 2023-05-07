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

        array[++rear % array.length] = e;
        size++;

        return true;
    }

    @Override
    public void resize(int newCapacity) {
        int arrayCapacity = array.length;

        Object[] newArray = new Object[newCapacity];

        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }
        this.array = null;
        this.array = newArray;

        front = 0;
        rear = size;
    }

    @Override
    public E poll() {
        if(isEmpty())
            return null;

        E returnData = (E)array[++front% array.length];
        array[front % array.length] = null;
        size--;
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
        array = new Object[10];
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
        T[] returnData;
        if(a.length < size){
            if(front <= rear)
                return (T[]) Arrays.copyOfRange(array, front + 1, rear + 1, a.getClass());

            returnData = (T[]) Arrays.copyOfRange(array, 0, size, a.getClass());
            int rearlength = array.length - 1 - front;
            if(rearlength > 0) {
                System.arraycopy(array, front + 1, returnData, 0, rearlength);
            }
            System.arraycopy(array, 0, returnData, rearlength, rear + 1);
            return returnData;
        }

        if(front <= rear) {
            System.arraycopy(array, front + 1, a, 0, size);
        }

        else {
            int rearlength = array.length - 1 - front;
            if(rearlength > 0) {
                System.arraycopy(array, front + 1, a, 0, rearlength);
            }
            System.arraycopy(array, 0, a, rearlength, rear + 1);
        }
        return a;
    }

}
