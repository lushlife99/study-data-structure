package Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayDeque<E> implements CustomArrayDeque<E>{

    private Object[] array;
    private int size;

    private int front;
    private int rear;

    public MyArrayDeque() {
        this.array = new Object[10];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }
    @Override
    public void resize(int newCapacity) {

        int arrayCapacity = array.length;
        Object[] newArray = new Object[newCapacity];

        int count = 1;
        for (int i = front + 1; count <= size; i++) {
            newArray[count++] = array[i % arrayCapacity];
        }

        this.array = newArray;

        front = 0;
        rear = size;
    }

    @Override
    public boolean offerLast(E item) {


        if(size == array.length - 1)
            resize(array.length * 2);

        rear = (rear+1) % array.length;
        array[rear] = item;
        size++;
        return true;
    }

    @Override
    public boolean offerFirst(E item) {
        if(size == array.length - 1)
            resize(array.length * 2);
        array[front--] = item;
        if(front < 0)
            front = array.length-1;

        size++;
        return true;
    }
    @Override
    public boolean offer(E e) {

        return offerLast(e);
    }

    @Override
    public E poll() {
        if(isEmpty())
            return null;

        front = (front + 1) % array.length;
        E returnData = (E)array[front];
        array[front] = null;
        size--;

        return returnData;
    }

    @Override
    public E peek() {

        return (E)array[(front+1) % array.length];
    }

    @Override
    public E pollFirst() {

        if(isEmpty())
            return null;

        return poll();
    }

    @Override
    public E remove() {

        return removeFirst();
    }

    @Override
    public E removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return pollFirst();
    }

    @Override
    public E pollLast() {

        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        E returnData = (E)array[rear];
        array[rear] = null;
        rear = (rear + array.length - 1) % array.length;
        size--;
        return returnData;
    }

    @Override
    public E removeLast() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return pollLast();
    }

    @Override
    public E peekFirst() {

        return (E)array[(front+1) % array.length];
    }

    @Override
    public E peekLast() {
        if(isEmpty())
            return null;

        return (E)array[rear];
    }

    @Override
    public E getFirst() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return (E)array[front];
    }

    @Override
    public E getLast() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return (E)array[rear];

    }

    @Override
    public boolean isEmpty() {

        return (rear + 1) % array.length == front;
    }

    @Override
    public boolean contains(Object value) {
        int cnt = 0;
        for (int i = front + 1; cnt++ < size; i++) {
            if(array[i % array.length].equals(value))
                return true;
        }

        return false;
    }

    @Override
    public void clear() {
        array = new Object[10];
        front = 0;
        rear = 0;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        final T[] res;
        if(a.length < size) {

            if(front <= rear) {
                return (T[]) Arrays.copyOfRange(array, front + 1, rear + 1, a.getClass());
            }

            res = (T[]) Arrays.copyOfRange(array, 0, size, a.getClass());
            int rearlength = array.length - 1 - front;    // 뒷 부분의 요소 개수

            if(rearlength > 0) {
                System.arraycopy(array, front + 1, res, 0, rearlength);
            }

            System.arraycopy(array, 0, res, rearlength, rear + 1);

            return res;
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

    @Override
    public Object[] toArray() {
        return toArray(new Object[size]);
    }

    @Override
    public int size() {
        return size;
    }
}
