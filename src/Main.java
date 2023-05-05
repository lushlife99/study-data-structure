import java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    public static void main (String [] args) throws IOException {
//        ListTest.arrayListTest();
//        ListTest.linkedListTest();

        ListTest.doubleLinkedListTest();

    }



}

class ListTest{
    public static void print(String testName, MyList c) throws IOException{
        Object[] array = c.toArray();

        System.out.println(testName);
        System.out.printf("사이즈 : "+c.size());
        System.out.printf(", 요소 : ");
        for (Object o : array) {
            System.out.printf(o+" ");
        }
        System.out.println("\n");
    }

    public static void arrayListTest() throws IOException{
        ArrayList<Integer> list = new ArrayList<>();

        MyArrayList myArrayList = new MyArrayList();
        int index = 0;
        int value = 0;
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        myArrayList.add(10);
        print("**************************************** ArrayList Test 초기 값 ****************************************", myArrayList);

        index = 1;
        value = 13;
        Object o = new Object();
        myArrayList.add(index, 13);
        print("add(index, value) Test. index = "+index+"value = "+value, myArrayList);

        myArrayList.remove(index);
        print("remove(index) Test. index = "+index, myArrayList);

        o = 10;
        myArrayList.remove(o);
        print("remove(Object o) Test, Object = "+o, myArrayList);

        MyArrayList clone = myArrayList.clone();
        System.out.println("clone HashCode = " + clone.toString());
        System.out.println("instance HashCode = " + myArrayList.toString());
        print("clone() Test.", clone);

        index = 3;
        print("get(index) Test. index = "+index+" return value = "+  myArrayList.get(3), myArrayList);

        print("indexOf(index) Test. object = "+o+" return value = "+ myArrayList.indexOf(o), myArrayList);


        index = 3;
        o = 33;
        myArrayList.set(index, o);
        print("set(index, value) Test. index = "+index+" object = "+o, myArrayList);

        myArrayList.clear();
        print("clear() Test.", myArrayList);

        System.out.println("*************************************** Test Finish ****************************************\n");

    }

    public static void linkedListTest() throws IOException{
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.add(8);
        myLinkedList.add(9);
        myLinkedList.add(10);
        Object o;
        print("**************************************** LinkedList Test 초기 값 ****************************************", myLinkedList);

        int index = 1;
        int value = 11;
        myLinkedList.add(index, value);
        print("add(index, value) Test. index = "+index+" value = "+value, myLinkedList);

        value = 12;
        myLinkedList.addFirst(value);
        print("addFirst(value) Test. value = "+value, myLinkedList);

        value = 13;
        myLinkedList.addLast(value);
        print("addLast(value) Test. value = "+value, myLinkedList);

        print("get(index) Test. index = "+index+" return data = "+myLinkedList.get(index), myLinkedList);
        index = 8;
        value = 0;
        myLinkedList.set(index, value);
        print("set(index, value) Test. index = "+index+" value = "+value, myLinkedList);

        o = 9;
        print("indexOf(Object) Test. Object = "+o+" return data = "+myLinkedList.indexOf(o), myLinkedList);


        print("remove() Test. return data = "+ myLinkedList.remove(), myLinkedList);
        print("remove(index) Test. index = "+index+" return data = "+ myLinkedList.remove(11), myLinkedList);
        print("remove(Object) Test. Object = "+o+ " return data = "+myLinkedList.remove(o), myLinkedList);
        System.out.println("**************************************** Test Finish ****************************************\n");
    }

    public static void doubleLinkedListTest() throws IOException{
        MyDoubleLinkedList<Integer> myLinkedList = new MyDoubleLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.add(8);
        myLinkedList.add(9);
        myLinkedList.add(10);
        Object o;
        print("**************************************** DoubleLinkedList Test 초기 값 ****************************************", myLinkedList);

        int index = myLinkedList.size();
        int value = 11;
        myLinkedList.add(index, value);
        print("add(index, value) Test. index = "+index+" value = "+value, myLinkedList);

        value = 12;
        myLinkedList.addFirst(value);
        print("addFirst(value) Test. value = "+value, myLinkedList);

        value = 13;
        myLinkedList.addLast(value);
        print("addLast(value) Test. value = "+value, myLinkedList);

        print("get(index) Test. index = "+index+" return data = "+myLinkedList.get(index), myLinkedList);
        index = 8;
        value = 0;
        myLinkedList.set(index, value);
        print("set(index, value) Test. index = "+index+" value = "+value, myLinkedList);

        o = 9;
        print("indexOf(Object) Test. Object = "+o+" return data = "+myLinkedList.indexOf(o), myLinkedList);


        print("remove() Test. return data = "+ myLinkedList.remove(), myLinkedList);
        print("remove(index) Test. index = "+index+" return data = "+ myLinkedList.remove(11), myLinkedList);
        print("remove(Object) Test. Object = "+o+ " return data = "+myLinkedList.remove(o), myLinkedList);
        System.out.println("**************************************** Test Finish ****************************************\n");
    }
}


















