import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class MyArrayList<E> implements CustomArrayList<E> {

    private E[] list;
    private int size;

    MyArrayList(){
        list = (E[]) new Object[10];
        size = 0;
    }
    MyArrayList(MyArrayList<E> myList){
        list = myList.toArray();
        size = myList.size;
    }

    @Override
    public boolean add(E value) {
        ensureCapacity(1);

        list[size++] = value;
        return true;
    }

    @Override
    public void add(int index, E value) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("범위를 벗어난 인덱스");

        ensureCapacity(1);

        for(int i = size-1; i >= index; i--){
            list[i+1] = list[i];
        }
        list[index] = value;
        size++;
    }

    @Override
    public void addLast(E value) {
        ensureCapacity(1);
        list[size++] = value;
    }

    @Override
    public void addFirst(E value) {
        ensureCapacity(1);
        for(int i = size-1; i >= 0; i--){
            list[i+1] = list[i];
        }
        list[0] = value;
        size++;
    }


    @Override
    public E remove(int index) {
        indexCheck(index);

        E result = list[index];
        for(int i = index+1; i < size; i++){
            list[i-1] = list[i];
        }
        list[size-1] = null;
        size--;
        return result;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if(index == -1)
            return false;

        remove(index);
        return true;
    }

    @Override
    public E get(int index) {
        indexCheck(index);

        return list[index];
    }

    @Override
    public void set(int index, E value) {
        indexCheck(index);

        list[index] = value;
    }

    @Override
    public boolean contains(Object value) {
        for (E e : list) {
            if(e.equals(value))
                return true;
        }
        return false;
    }

    @Override
    public void clear() {
        list = (E[]) new Object[10];
        size = 0;
    }

    public MyArrayList<E> clone(){
        return new MyArrayList<>(this);
    }


    @Override
    public int lastIndexOf(Object value) {
        for(int index = size-1; index >=0; index--){
            if(value.equals(list[index]))
                return index;
        }
        return -1;
    }


    @Override
    public int indexOf(Object value) {
        for(int i = 0; i < size; i++){
            if(list[i].equals(value))
                return i;
        }
        return -1;
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


    /**
     * 자바에 소멸자가 없는데..
     * 이렇게 함수짜면 메모리가 낭비되지 않을까?
     *
     * 자바의 Garbage Collection -> 특정 개체에 대한 참조가 없으면 알아서 메모리를 회수해줌.
     * 결론 : 이렇게해도 메모리 낭비 X.
     * @param minCapacity
     */
    private void ensureCapacity(int minCapacity){
        int calSize = list.length;
        if(calSize < size + minCapacity)
            calSize *= 2;

        list = toArray((E[])new Object[calSize]);
    }

    public <E> E[]	toArray(E[] a){
        int iterSize = size;
        if(a.length < size)
            iterSize = a.length;

        for(int i = 0; i < iterSize; i++){
            a[i] = (E) list[i];
        }
        return a;
    }

    public E[] toArray(){
        return Arrays.copyOf(list, size);
    }

    private void indexCheck(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("범위를 벗어난 인덱스");
    }

    @Override
    public void resize() {
    }


}