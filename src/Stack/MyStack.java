package Stack;

public class MyStack<E> implements StackInterface<E> {

    E[] array;
    int size;

    public MyStack(){
        array = (E[])new Object[10];
        size = 0;
    }

    private void resize(){

        if(size == array.length) {
            int newCapacity = Math.max(array.length * 2, 10);
            E[] newArray = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            return;
        }

        if(size < array.length / 2 && array.length > 10){
            E[] newArray = (E[]) new Object[array.length / 2];
            for(int i = 0; i < size; i++){
                newArray[i] = array[i];
            }
        }
    }
    @Override
    public E push(E item) {
        if(size == array.length)
            resize();

        array[size++] = item;
        return array[size-1];
    }

    @Override
    public E pop() {
        if(empty())
            return null;

        E returnData = array[--size];
        array[size] = null;
        resize();
        return returnData;
    }

    @Override
    public E peek() {
        if(empty())
            return null;

        return array[size-1];
    }

    @Override
    public int search(Object value) {
        for(int i = size-1; i>=0; i--) {
            if(array[i].equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            array[i] = null;
        }

        size = 0;
        array = (E[])new Object[0];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }
}