

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

import javax.swing.*;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private float R;


    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[4];
        size = 0;
        nextFirst=0;
        nextLast=1;
        R=(float)size/(float)items.length;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size==items.length){
            resize(size*2);
        }
        items[size] = x;
        size = size + 1;
        nextLast=addOne(nextLast);
        R=(float)size/(float)items.length;
    }

    public void addFirst(T x){

        size = size + 1;
        items[nextFirst]=x;
        if(size==items.length){
            resize(size*2);
            return ;
        }
        nextFirst=minusOne(nextFirst);
      /*  if (nextFirst!=0){
            nextFirst=nextFirst-1;
        }
        else {
            nextFirst=items.length-1;
        }*/
        R=(float)size/(float)items.length;
    }

    /*A helper function to compute array index(addFirst,removeLast)*/
    private int minusOne(int index){
        index=index-1;
        if (index<0)
            index=index+items.length;
        return index;
    }

    /*A helper function to compute array index(removeFirst, addLast)*/
    private int addOne(int index){
        index=index+1;
        if(index>items.length) {
            index = index % items.length;
        }
        return index;
    }

    private void resize(int capacity){
        T [] a =(T[])new  Object[capacity];

        System.arraycopy(items,nextFirst,a,0,size-nextFirst);
        System.arraycopy(items,0,a,size-nextFirst,nextFirst);
        items=a;
        nextFirst=2*size-1;
        nextLast=size;
        R=(float)size/(float)items.length;
    }

    /*check if the Array is empty*/
    public boolean isEmpty(){
        if (nextFirst==nextLast-1)
            return true;
        return false;
    }

    /*check the size of the array*/
    public int size(){
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T x = getLast();
        size = size - 1;
        if (R<0.25){
            resize((int)0.5*items.length);
        }
        items[nextLast-1]=null;
        nextLast=minusOne(nextLast);
        R=(float)size/(float)items.length;
        return x;
    }

    /*Delete item form the head of the list and
    * returns deleted item*/
    public T removeFirst(){
        T x =getFirst();
        size-=1;
        if (R<0.25){
            resize((int)0.5*items.length);
        }
        items[nextFirst-1]=null;
        nextLast=addOne(nextLast);
        R=(float)size/(float)items.length;
        return x;
    }
    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[nextLast-1];
    }

    public T getFirst(){
        if (nextFirst==items.length-1)
        {
        return items[0];
        }
        else{
            return items[nextFirst-1];
        }
    }
    public T get(int i) {
        return items[i];
    }

    /*print all item[i] in sequence*/
    public void printDeque(){
        if(nextLast>nextFirst){
            for(int i=nextFirst-1;i<nextLast;i++){
                System.out.println(items[i]);
            }
        }
        else {
            for(int i=nextFirst-1;i<size;i++) {
                System.out.println(items[i]);
            }
            for(int i=0;i<nextLast;i++) {
                System.out.println(items[i]);
            }
        }
    }




    public static void main(String[] args){
        ArrayDeque L= new ArrayDeque();
        L.addLast(3);
        L.addLast(2);
        L.addFirst(11);


        //System.out.println(L.removeLast());
        System.out.println(L.items[2]);

    }
}