public class LinkedListDeque<T> implements Deque<T>{
    /*NESTED Classes*/
    public class Deque {
        public T item;
        public Deque next;
        public Deque prev;

        public Deque(Deque j,T i, Deque n) {
            prev = j;
            item = i;
            next = n;
        }
    }


    public int size;
    public Deque last;
    private Deque sentinel;

    public LinkedListDeque(){
        sentinel = new Deque(null,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }

    @Override
    /*add last*/
    public void addLast(T x) {
        size += 1;
        //why null is not sentinel//
        //last.next = new Deque(last, x, null);
        sentinel.prev.next= new Deque(sentinel.prev,x,sentinel);
        sentinel.prev=sentinel.prev.next;

    }

    @Override
    public void addFirst(T x){
        //I really do not know why
        sentinel.next.prev= new Deque(sentinel,x, sentinel.next);
       // sentinel.next.prev = node;
        sentinel.next = sentinel.next.prev;


       /* sentinel.next= new Deque(sentinel,x,sentinel.next);
        sentinel.next.prev=sentinel.next;*/
        //sentinel.prev=sentinel.prev.prev.next;
        size=size+1;
    }

    @Override
    public T removeFirst(){
        T x =sentinel.item;
        sentinel.next=sentinel.next.next;
        return x;
    }
    public T removeLast(){
        T x =sentinel.prev.item;
        sentinel.prev=null;
        return x;
    }

    public T getFirst(){
        return sentinel.next.item;
    }

    @Override
    /* calucate the size of first with overloaded*/
    public int size(){
        return size(sentinel.next);
    }

    private int size(Deque p){
        if(p == sentinel){
            return 0;
        }
        return 1 +size(p.next);
    }
    /* get size
    /* get index x of snetinel */
    public T get(int index){
        Deque P=sentinel.next;
        for(int i=0;i<index;i++){
            P=P.next;
        }
        return P.item;
    }
    /*get index x of sentinel*/
    public T getRecursive(int index){
        Deque p=sentinel;
        return  helpgetRecursive(index,p);
    }
    public T helpgetRecursive(int index,Deque p){
        if (index==0){
            return p.next.item;
        }
        p=p.next;
        return helpgetRecursive(index-1,p);
    }
    public boolean isEmpty(){
        if(sentinel.next==sentinel){
            return true;
        }
        return false;
    }
    /*add an item to the end of the list*/
    /*public void addLast(int x){
        Deque p=sentinel;
        while (p.next!=null){
            p=p.next;
        }
        p.next=new Deque(x,null);
        size=size+1;
    }*/

    /* get the last item of the list*/
    public T getLast(){
        Deque p=sentinel;
        while (p.next!=null){
            p=p.next;
        }
        return p.item;
    }
   /*print all items of L*/
    public void printDeque(){
        Deque p=sentinel.next;
        for(int i=0;i<size;i++){
            System.out.println(p.item);
            p=p.next;
        }
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> L = new LinkedListDeque();

          L.addFirst(4);
          L.addLast(5);
          L.addFirst(3);
        // L is  5 6 5 3
       // L.removeFirst();
        //L.removeLast();
        //System.out.println("the first item is "+L.getFirst());
        // System.out.println("the first item is "+L.getFirst());
        System.out.println("the size of L is "+L.size());
        //System.out.println(L.size);
        L.printDeque();
        System.out.println(L.isEmpty());
        int index=1;
        System.out.println("the item "+index+" of sentinel is "+ L.getRecursive(index));

        //int x =L.getFirst();
        //sentinel之间的联系不太对（prev和nest），还有remove first和remove last
    }
}
