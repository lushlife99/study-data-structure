package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyHeap<E> {

    protected final Comparator<? super E> comparator;
    protected Object[] array;
    protected int size;

    public MyHeap() {
        this(null);
    }

    public MyHeap(Comparator<? super E> comparator) {
        this.array = new Object[10];
        this.size = 0;
        this.comparator = comparator;
    }

    public MyHeap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private int getLeftChild(int index) {
        return index * 2;
    }

    private int getRightChild(int index) {
        return index * 2 + 1;
    }
    private void resize(int newCapacity){
        Object[] newArray = new Object[newCapacity];

        for(int i = 1; i <= size; i++){
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public void add(E value){
        if(array.length == size + 1)
            resize(array.length * 2);

        siftUp(size + 1, value);
        size++;
    }

    private void siftUp(int idx, E target){

        if(comparator != null) {
            siftUpComparator(idx, target, comparator);
        }
        else {
            siftUpComparable(idx, target);
        }
    }

    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
        while(idx > 1){
            Object parentElement = array[idx/2];
            if(comp.compare(target, (E)parentElement) >= 0)
                break;

            array[idx] = parentElement;
            idx/=2;
        }
    }
    private void siftUpComparable(int idx, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while(idx > 1){
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal) >= 0) {
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = comp;
    }

    public E remove() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        E returnData = (E)array[1];
        E target = (E) array[size];
        array[size] = null;

        siftDown(1, target);

        return returnData;
    }

    private void siftDown(int idx, E target) {
        if(comparator != null) {
            siftDownComparator(idx, target, comparator);
        }
        else {
            siftDownComparable(idx, target);
        }
    }

    private void siftDownComparator(int idx, E target, Comparator<? super E> comp) {
        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);

            Object childVal = array[child];

            if(right <= size && comp.compare((E) childVal, (E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if(comp.compare(target ,(E) childVal) <= 0){
                break;
            }

            array[parent] = childVal;
            parent = child;
        }

        array[parent] = target;

        if(array.length > 10 && size < array.length / 4) {
            resize(Math.max(10, array.length / 2));
        }

    }

    private void siftDownComparable(int idx, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);

            Object childVal = array[child];

            if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if(comp.compareTo((E) childVal) <= 0){
                break;
            }
            array[parent] = childVal;
            parent = child;

        }
        array[parent] = comp;

        if(array.length > 10 && size < array.length / 4) {
            resize(Math.max(10, array.length / 2));
        }

    }

    public int size() {
        return size;
    }

    public E peek() {
        if(isEmpty())
            throw new NoSuchElementException("비어있음");

        return (E)array[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size+1);
    }

}
