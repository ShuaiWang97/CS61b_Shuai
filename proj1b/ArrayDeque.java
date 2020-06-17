

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/



public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private float R;


    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[4];
        size = 0;
        nextFirst = 3;
        nextLast = 0;
        R = (float) size / (float) items.length;
    }

    @Override
    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        items[size] = x;
        size = size + 1;
        if (size == items.length) {
            resize(size * 2);
            R = (float) size / (float) items.length;
            return;
        }
        nextLast = addOne(nextLast);
        R = (float) size / (float) items.length;
    }

    @Override
    public void addFirst(T x) {
        size = size + 1;
        items[nextFirst] = x;
        if (size == items.length){
            resize(size * 2);
            return ;
        }
        nextFirst = minusOne(nextFirst);
        R = (float) size / (float) items.length;
    }


    /*A helper function to compute array index(addFirst,removeLast)*/
    private int minusOne (int index) {
        index = index - 1;
        if ( index < 0 )
            index = index + items.length;
        return index;
    }

    /*A helper function to compute array index(removeFirst, addLast)*/
    private int addOne(int index) {
        index = index + 1;
        if (index >= items.length) {
            index = index % items.length;
        }
        return index;
    }


    private void resize(int capacity) {
        T [] a = (T[]) new Object[capacity];

        if (capacity == 2 * size) {
            System.arraycopy(items, 0, a, 0, size);

        } else if (nextLast > nextFirst) {
            System.arraycopy(items,nextFirst + 1,a,0,size);
        } else if (nextLast < nextFirst) {
            System.arraycopy(items,nextFirst + 1,a,0 , size - nextFirst-1);
            System.arraycopy(items, 0, a, size-nextFirst-1, nextLast);
        }
        items = a;
        nextFirst = capacity-1;
        nextLast = size;

        R = (float)size / (float)items.length;
    }


    @Override
    /*check if the Array is empty*/
    public boolean isEmpty() {
        if (nextFirst == nextLast-1)
            return true;
        return false;
    }

    @Override
    /*check the size of the array*/
    public int size() {
        return size;
    }

    @Override
    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T x = getLast();
        if (R < 0.25) {
            resize((int) Math.round(0.5 * (double) items.length));
        }
        size = size - 1;
        items[nextLast - 1] = null;
        nextLast = minusOne(nextLast);
        R = (float)size / (float)items.length;
        return x;
    }

    @Override
    /*Delete item form the head of the list and
    * returns deleted item*/
    public T removeFirst(){
        T x = getFirst();

        if (R < 0.25){
            resize((int)Math.round(0.5 * (double)items.length));
        }
        size -= 1;
        items[addOne(nextFirst)] = null;
        nextFirst = addOne(nextFirst);
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
            return items[nextFirst+1];
        }
    }
    @Override
    public T get(int i) {
        return items[i];
    }

    @Override
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