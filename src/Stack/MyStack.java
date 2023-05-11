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
            E[] newArray = (E[]) new Object[array.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            return;
        }

        if(size < array.length / 2){
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

        return array[--size];
    }

    @Override
    public E peek() {
        if(empty())
            return null;

        return array[size-1];
    }

    @Override
    public int search(Object value) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(value))
                return size - i;
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