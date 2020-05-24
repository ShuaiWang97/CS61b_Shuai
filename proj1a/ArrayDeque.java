

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

public class ArrayDeque {
    private int[] items;
    private int size;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = new int[2];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size==items.length){
            resize(size+1);
        }
        items[size] = x;
        size = size + 1;
    }

    private void resize(int capacity){
            int [] a =new int[capacity];
            System.arraycopy(items,0,a,0,size);
            items=a;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int x = getLast();
        size = size - 1;
        return x;
    }
    public static void main(String[] args){
        ArrayDeque L= new ArrayDeque();
        L.addLast(3);
        L.addLast(2);
        L.addLast(11);
        System.out.println(L.removeLast());


    }
}